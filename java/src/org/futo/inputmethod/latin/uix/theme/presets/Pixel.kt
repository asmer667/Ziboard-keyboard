package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF8AB4F8),
    onPrimary=Color(0xFF202124),
    primaryContainer=Color(0xFF2D2E31),
    onPrimaryContainer=Color(0xFF8AB4F8),
    secondary=Color(0xFF8AB4F8),
    onSecondary=Color(0xFF202124),
    secondaryContainer=Color(0xFF2D2E31),
    onSecondaryContainer=Color(0xFFE8EAED),
    tertiary=Color(0xFF8AB4F8),
    onTertiary=Color(0xFF202124),
    tertiaryContainer=Color(0xFF2D2E31),
    onTertiaryContainer=Color(0xFFE8EAED),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF202124),
    outline=Color(0xFF3C4043),
    outlineVariant=Color(0xFF2D2E31),
    surface=Color(0xFF202124),
    onSurface=Color(0xFFE8EAED),
    onSurfaceVariant=Color(0xFFE8EAED),
    surfaceContainerHighest=Color(0xFF3C4043),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF202124),
    keyboardContainer=Color(0xFF2D2E31),
    keyboardContainerVariant=Color(0xFF2D2E31).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFE8EAED),
    keyboardPress=Color(0xFF3C4043),
    keyboardFade0=Color(0xFF202124),
    keyboardFade1=Color(0xFF202124),
    primaryTransparent=Color(0xFF8AB4F8).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFE8EAED).copy(alpha = 0.1f),
)

val Pixel = ThemeOption(
    dynamic = false,
    key = "Pixel",
    name = R.string.theme_pixel,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Pixel)
}
