package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFEBBCBA),
    onPrimary=Color(0xFF191724),
    primaryContainer=Color(0xFF1F1D2E),
    onPrimaryContainer=Color(0xFFEBBCBA),
    secondary=Color(0xFFEBBCBA),
    onSecondary=Color(0xFF191724),
    secondaryContainer=Color(0xFF1F1D2E),
    onSecondaryContainer=Color(0xFFE0DEF4),
    tertiary=Color(0xFFEBBCBA),
    onTertiary=Color(0xFF191724),
    tertiaryContainer=Color(0xFF1F1D2E),
    onTertiaryContainer=Color(0xFFE0DEF4),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF191724),
    outline=Color(0xFF26233A),
    outlineVariant=Color(0xFF1F1D2E),
    surface=Color(0xFF191724),
    onSurface=Color(0xFFE0DEF4),
    onSurfaceVariant=Color(0xFFE0DEF4),
    surfaceContainerHighest=Color(0xFF26233A),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF191724),
    keyboardContainer=Color(0xFF1F1D2E),
    keyboardContainerVariant=Color(0xFF1F1D2E).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFE0DEF4),
    keyboardPress=Color(0xFF26233A),
    keyboardFade0=Color(0xFF191724),
    keyboardFade1=Color(0xFF191724),
    primaryTransparent=Color(0xFFEBBCBA).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFE0DEF4).copy(alpha = 0.1f),
)

val RosePine = ThemeOption(
    dynamic = false,
    key = "RosePine",
    name = R.string.theme_rose_pine,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(RosePine)
}
