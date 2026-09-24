package org.futo.inputmethod.latin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.graphics.Color
import android.inputmethodservice.InputMethodService
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.CompletionInfo
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InlineSuggestionsRequest
import android.view.inputmethod.InlineSuggestionsResponse
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodSubtype
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.futo.inputmethod.accessibility.AccessibilityUtils
import org.futo.inputmethod.engine.ExpandableSuggestionBarConfiguration
import org.futo.inputmethod.engine.IMEManager
import org.futo.inputmethod.engine.general.WordLearner
import org.futo.inputmethod.latin.SuggestedWords.SuggestedWordInfo
import org.futo.inputmethod.latin.common.Constants
import org.futo.inputmethod.latin.settings.Settings
import org.futo.inputmethod.latin.uix.BasicThemeProvider
import org.futo.inputmethod.latin.uix.DataStoreHelper
import org.futo.inputmethod.latin.uix.DynamicThemeProvider
import org.futo.inputmethod.latin.uix.DynamicThemeProviderOwner
import org.futo.inputmethod.latin.uix.EmojiTracker.useEmoji
import org.futo.inputmethod.latin.uix.HiddenKeysSetting
import org.futo.inputmethod.latin.uix.KeyBordersSetting
import org.futo.inputmethod.latin.uix.KeyHintsSetting
import org.futo.inputmethod.latin.uix.KeyboardColorScheme
import org.futo.inputmethod.latin.uix.SUGGESTION_BLACKLIST
import org.futo.inputmethod.latin.uix.SettingsKey
import org.futo.inputmethod.latin.uix.THEME_KEY
import org.futo.inputmethod.latin.uix.UixManager
import org.futo.inputmethod.latin.uix.actions.CanThrowIfDebug
import org.futo.inputmethod.latin.uix.createInlineSuggestionsRequest
import org.futo.inputmethod.latin.uix.dataStore
import org.futo.inputmethod.latin.uix.differsFrom
import org.futo.inputmethod.latin.uix.forceUnlockDatastore
import org.futo.inputmethod.latin.uix.getSetting
import org.futo.inputmethod.latin.uix.getSettingBlocking
import org.futo.inputmethod.latin.uix.getSettingFlow
import org.futo.inputmethod.latin.uix.isDirectBootUnlocked
import org.futo.inputmethod.latin.uix.safeKeyboardPadding
import org.futo.inputmethod.latin.uix.setSetting
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.applyWindowColors
import org.futo.inputmethod.latin.uix.theme.getThemeOption
import org.futo.inputmethod.latin.uix.theme.orDefault
import org.futo.inputmethod.latin.uix.theme.presets.DefaultDarkScheme
import org.futo.inputmethod.latin.utils.JniUtils
import org.futo.inputmethod.updates.scheduleUpdateCheckingJob
import org.futo.inputmethod.v2keyboard.ComputedKeyboardSize
import org.futo.inputmethod.v2keyboard.FloatingKeyboardSize
import org.futo.inputmethod.v2keyboard.KeyboardSettings
import org.futo.inputmethod.v2keyboard.KeyboardSizeSettingKind
import org.futo.inputmethod.v2keyboard.KeyboardSizeStateProvider
import org.futo.inputmethod.v2keyboard.KeyboardSizingCalculator
import org.futo.inputmethod.v2keyboard.LayoutManager
import org.futo.inputmethod.v2keyboard.dimensionsSameAs
import org.futo.inputmethod.v2keyboard.getPrimaryLayoutOverride
import org.futo.inputmethod.v2keyboard.isFoldableInnerDisplayAllowed
import kotlin.math.roundToInt

/** Whether or not we can render into the navbar */
val SupportsNavbarExtension = Build.VERSION.SDK_INT >= 28

val SupportsNonComposing = Build.VERSION.SDK_INT >= 31

val UseTransparentNavbar =
    // https://github.com/futo-org/android-keyboard/issues/772
    !Build.MANUFACTURER.lowercase().contains("motorola")

val HideKeyboardWhenHardKeyboardConnected = SettingsKey(
    booleanPreferencesKey("hideKeyboardWhenHardKeyboardConnected"),
    false
)

private class UnlockedBroadcastReceiver(val onDeviceUnlocked: () -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_USER_UNLOCKED) {
            onDeviceUnlocked()
        }
    }
}

open class InputMethodServiceCompose : InputMethodService(), LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    private lateinit var mLifecycleRegistry: LifecycleRegistry
    private lateinit var mViewModelStore: ViewModelStore
    private lateinit var mSavedStateRegistryController: SavedStateRegistryController

    fun setOwners() {
        val decorView = window.window?.decorView
        decorView?.setViewTreeLifecycleOwner(this)
        decorView?.setViewTreeViewModelStoreOwner(this)
        decorView?.setViewTreeSavedStateRegistryOwner(this)
    }

    override fun onCreate() {
        super.onCreate()

        mLifecycleRegistry = LifecycleRegistry(this)
        mLifecycleRegistry.currentState = Lifecycle.State.INITIALIZED

        mViewModelStore = ViewModelStore()

        mSavedStateRegistryController = SavedStateRegistryController.create(this)
        mSavedStateRegistryController.performRestore(null)

        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    override fun onDestroy() {
        super.onDestroy()
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    override fun onWindowShown() {
        super.onWindowShown()
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onWindowHidden() {
        super.onWindowHidden()
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    }

    override val lifecycle: Lifecycle
        get() = mLifecycleRegistry
    override val savedStateRegistry: SavedStateRegistry
        get() = mSavedStateRegistryController.savedStateRegistry
    override val viewModelStore: ViewModelStore
        get() = mViewModelStore

    internal var composeView: ComposeView? = null

    override fun onCreateInputView(): View =
        ComposeView(this).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setParentCompositionContext(null)

            setOwners()

            composeView = this
        }
}

class LatinIME : InputMethodServiceCompose(), LatinIMELegacy.SuggestionStripController,
        DynamicThemeProviderOwner, FoldStateProvider, KeyboardSizeStateProvider {

    val imeManager = IMEManager(this)

    val latinIMELegacy = LatinIMELegacy(
        this as InputMethodService,
        this as LatinIMELegacy.SuggestionStripController,
    )

    val uixManager = UixManager(this)

    val sizingCalculator = KeyboardSizingCalculator(this, uixManager)

    private var activeThemeOption: ThemeOption? = null
    private val activeColorScheme = mutableStateOf(DefaultDarkScheme.obtainColors(this))
    private var pendingRecreateKeyboard: Boolean = false

    val colorScheme get() = activeColorScheme.value
    val keyboardColor get() = colorScheme.keyboardSurface.let { fallback ->
        drawableProvider?.keyboardColor?.let { androidx.compose.ui.graphics.Color(it) } ?: fallback
    }

    val size: MutableState<ComputedKeyboardSize?> = mutableStateOf(null)
    private fun calculateSize(): ComputedKeyboardSize? = sizingCalculator.calculate(
        getPrimaryLayoutOverride(currentInputEditorInfo) ?: latinIMELegacy.mKeyboardSwitcher.keyboard?.mId?.mKeyboardLayoutSetName ?: "qwerty",
        Settings.getInstance().current
    )

    private var drawableProvider: DynamicThemeProvider? = null

    private var settingsRefreshRequired = false
    private fun recreateKeyboard() {
        latinIMELegacy.updateTheme()

        if(settingsRefreshRequired) {
            latinIMELegacy.mKeyboardSwitcher.loadKeyboard(
                currentInputEditorInfo ?: return,
                latinIMELegacy.mSettings.current,
                latinIMELegacy.currentAutoCapsState
            )
        } else {
            latinIMELegacy.mKeyboardSwitcher.mState.onLoadKeyboard(
                currentInputEditorInfo ?: return,
                latinIMELegacy.currentAutoCapsState,
        
