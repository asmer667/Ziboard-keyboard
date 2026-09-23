package org.futo.inputmethod.latin.uix.theme

import android.content.Context
import android.graphics.Typeface
import org.futo.inputmethod.latin.uix.FONT_KEY
import org.futo.inputmethod.latin.uix.KeyboardColorScheme
import org.futo.inputmethod.latin.uix.getSettingBlocking

data class KeyboardFont(
    val key: String,
    val displayName: String,
    val assetPath: String?
)

val KeyboardFonts: List<KeyboardFont> = listOf(
    KeyboardFont("", "System Default", null),
    KeyboardFont("NotoSans", "Noto Sans", "fonts/NotoSans.ttf"),
    KeyboardFont("NotoSerif", "Noto Serif", "fonts/NotoSerif.ttf"),
    KeyboardFont("NotoSansMono", "Noto Sans Mono", "fonts/NotoSansMono.ttf"),
    KeyboardFont("SourceCodePro", "Source Code Pro", "fonts/SourceCodePro.otf"),
    KeyboardFont("Carlito", "Carlito", "fonts/Carlito.ttf"),
    KeyboardFont("Caladea", "Caladea", "fonts/Caladea.ttf"),
    KeyboardFont("LiberationSans", "Liberation Sans", "fonts/LiberationSans.ttf"),
    KeyboardFont("LiberationSerif", "Liberation Serif", "fonts/LiberationSerif.ttf"),
    KeyboardFont("LiberationMono", "Liberation Mono", "fonts/LiberationMono.ttf"),
    KeyboardFont("RedHatDisplay", "Red Hat Display", "fonts/RedHatDisplay.otf"),
    KeyboardFont("RedHatText", "Red Hat Text", "fonts/RedHatText.otf"),
    KeyboardFont("Cantarell", "Cantarell", "fonts/Cantarell.otf"),
    KeyboardFont("DejaVuSans", "DejaVu Sans", "fonts/DejaVuSans.ttf"),
    KeyboardFont("Anton", "Anton", "fonts/Anton-Regular.ttf"),
)

private val typefaceCache = HashMap<String, Typeface?>()

fun keyboardFontByKey(key: String): KeyboardFont? =
    KeyboardFonts.firstOrNull { it.key == key }

fun loadKeyboardFont(context: Context, key: String): Typeface? {
    if (key.isBlank()) return null
    typefaceCache[key]?.let { return it }
    val font = keyboardFontByKey(key) ?: return null
    val path = font.assetPath ?: return null
    return try {
        val tf = Typeface.createFromAsset(context.assets, path)
        typefaceCache[key] = tf
        tf
    } catch (e: Exception) {
        null
    }
}

fun KeyboardColorScheme.withGlobalFont(context: Context): KeyboardColorScheme {
    val key = try {
        context.getSettingBlocking(FONT_KEY)
    } catch (e: Exception) {
        ""
    }

    val typeface = loadKeyboardFont(context, key) ?: return this
    return this.copy(
        extended = this.extended.copy(
            advancedThemeOptions = this.extended.advancedThemeOptions.copy(font = typeface)
        )
    )
}
