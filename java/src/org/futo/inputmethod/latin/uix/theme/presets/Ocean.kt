package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF4FC3F7),
    onPrimary=Color(0xFF0B2027),
    primaryContainer=Color(0xFF10313B),
    onPrimaryContainer=Color(0xFF4FC3F7),
    secondary=Color(0xFF4FC3F7),
    onSecondary=Color(0xFF0B2027),
    secondaryContainer=Color(0xFF10313B),
    onSecondaryContainer=Color(0xFFD6F0F5),
    tertiary=Color(0xFF4FC3F7),
    onTertiary=Color(0xFF0B2027),
    tertiaryContainer=Color(0xFF10313B),
    onTertiaryContainer=Color(0xFFD6F0F5),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF0B2027),
    outline=Color(0xFF184655),
    outlineVariant=Color(0xFF10313B),
    surface=Color(0xFF0B2027),
    onSurface=Color(0xFFD6F0F5),
    onSurfaceVariant=Color(0xFFD6F0F5),
    surfaceContainerHighest=Color(0xFF184655),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF0B2027),
    keyboardContainer=Color(0xFF10313B),
    keyboardContainerVariant=Color(0xFF10313B).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFD6F0F5),
    keyboardPress=Color(0xFF184655),
    keyboardFade0=Color(0xFF0B2027),
    keyboardFade1=Color(0xFF0B2027),
    primaryTransparent=Color(0xFF4FC3F7).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFD6F0F5).copy(alpha = 0.1f),
)

val Ocean = ThemeOption(
    dynamic = false,
    key = "Ocean",
    name = R.string.theme_ocean,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Ocean)
}
