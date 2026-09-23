package org.futo.inputmethod.latin.uix.theme

import android.content.Context
import androidx.annotation.StringRes
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.KeyboardColorScheme
import org.futo.inputmethod.latin.uix.actions.BugInfo
import org.futo.inputmethod.latin.uix.actions.BugViewerState
import org.futo.inputmethod.latin.uix.theme.presets.AMOLEDDarkPurple
import org.futo.inputmethod.latin.uix.theme.presets.CatppuccinMocha
import org.futo.inputmethod.latin.uix.theme.presets.ClassicMaterialDark
import org.futo.inputmethod.latin.uix.theme.presets.ClassicMaterialLight
import org.futo.inputmethod.latin.uix.theme.presets.CottonCandy
import org.futo.inputmethod.latin.uix.theme.presets.DeepSeaDark
import org.futo.inputmethod.latin.uix.theme.presets.DeepSeaLight
import org.futo.inputmethod.latin.uix.theme.presets.DefaultDarkScheme
import org.futo.inputmethod.latin.uix.theme.presets.DefaultLightScheme
import org.futo.inputmethod.latin.uix.theme.presets.DynamicDarkTheme
import org.futo.inputmethod.latin.uix.theme.presets.DynamicLightTheme
import org.futo.inputmethod.latin.uix.theme.presets.DynamicSystemTheme
import org.futo.inputmethod.latin.uix.theme.presets.Emerald
import org.futo.inputmethod.latin.uix.theme.presets.Gradient1
import org.futo.inputmethod.latin.uix.theme.presets.HotDog
import org.futo.inputmethod.latin.uix.theme.presets.Snowfall
import org.futo.inputmethod.latin.uix.theme.presets.SteelGray
import org.futo.inputmethod.latin.uix.theme.presets.Sunflower
import org.futo.inputmethod.latin.uix.theme.presets.VoiceInputTheme
import org.futo.inputmethod.latin.uix.theme.presets.DevTheme
import org.futo.inputmethod.latin.uix.theme.presets.HighContrastYellow
import org.futo.inputmethod.latin.uix.theme.presets.AMOLEDBlack
import org.futo.inputmethod.latin.uix.theme.presets.Dracula
import org.futo.inputmethod.latin.uix.theme.presets.Nord
import org.futo.inputmethod.latin.uix.theme.presets.TokyoNight
import org.futo.inputmethod.latin.uix.theme.presets.Gruvbox
import org.futo.inputmethod.latin.uix.theme.presets.OneDark
import org.futo.inputmethod.latin.uix.theme.presets.Everforest
import org.futo.inputmethod.latin.uix.theme.presets.RosePine
import org.futo.inputmethod.latin.uix.theme.presets.SolarizedDark
import org.futo.inputmethod.latin.uix.theme.presets.Monokai
import org.futo.inputmethod.latin.uix.theme.presets.Glass
import org.futo.inputmethod.latin.uix.theme.presets.Cyberpunk
import org.futo.inputmethod.latin.uix.theme.presets.Ocean
import org.futo.inputmethod.latin.uix.theme.presets.Forest
import org.futo.inputmethod.latin.uix.theme.presets.Sunset
import org.futo.inputmethod.latin.uix.theme.presets.Aurora
import org.futo.inputmethod.latin.uix.theme.presets.Midnight
import org.futo.inputmethod.latin.uix.theme.presets.Pixel

data class ThemeOption(
    val dynamic: Boolean,
    val key: String,
    @StringRes val name: Int,
    val available: (Context) -> Boolean,
    val obtainColors: (Context) -> KeyboardColorScheme,
)

val ThemeOptions = mapOf(
    // Curated polished default set
    DynamicSystemTheme.key to DynamicSystemTheme, // Material You
    DefaultDarkScheme.key to DefaultDarkScheme,
    DefaultLightScheme.key to DefaultLightScheme,

    AMOLEDBlack.key to AMOLEDBlack,
    Dracula.key to Dracula,
    Nord.key to Nord,
    CatppuccinMocha.key to CatppuccinMocha,
    TokyoNight.key to TokyoNight,
    Gruvbox.key to Gruvbox,
    OneDark.key to OneDark,
    Everforest.key to Everforest,
    RosePine.key to RosePine,
    SolarizedDark.key to SolarizedDark,
    Monokai.key to Monokai,
    Glass.key to Glass,
    Cyberpunk.key to Cyberpunk,
    Ocean.key to Ocean,
    Forest.key to Forest,
    Sunset.key to Sunset,
    Aurora.key to Aurora,
    Midnight.key to Midnight,
    Pixel.key to Pixel,
)

val ThemeOptionKeys = ThemeOptions.keys

fun defaultThemeOption(context: Context): ThemeOption =
    if(context.resources.getBoolean(R.bool.use_dev_styling)) {
        DevTheme
    } else {
        if(DynamicSystemTheme.available(context)) {
            DynamicSystemTheme
        } else {
            DefaultDarkScheme
        }
    }

fun getThemeOption(context: Context, key: String): ThemeOption? {
    return ThemeOptions[key] ?: run {
        return ZipThemes.ThemeFileName.fromSetting(key)?.let { name ->
            ThemeOption(
                dynamic = false,
                key = key,
                name = 0,
                available = { true },
                obtainColors = {
                    try {
                        ZipThemes.loadScheme(context, name)
                    } catch(e: Exception) {
                        BugViewerState.pushBug(BugInfo(
                            name = "Theme $name",
                            details = e.toString(),
                        ))
                        defaultThemeOption(context).obtainColors(it)
                    }
                }
            )
        }
    }
}

fun ThemeOption?.orDefault(context: Context): ThemeOption {
    val themeOptionFromSettings = this
    val themeOption = when {
        themeOptionFromSettings == null -> defaultThemeOption(context)
        !themeOptionFromSettings.available(context) -> defaultThemeOption(context)
        else -> themeOptionFromSettings
    }

    return themeOption.copy(
        obtainColors = { ctx -> themeOption.obtainColors(ctx).withGlobalFont(ctx) }
    )
}