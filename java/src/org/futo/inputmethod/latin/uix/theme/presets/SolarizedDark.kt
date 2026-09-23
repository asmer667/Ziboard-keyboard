package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF268BD2),
    onPrimary=Color(0xFF002B36),
    primaryContainer=Color(0xFF073642),
    onPrimaryContainer=Color(0xFF268BD2),
    secondary=Color(0xFF268BD2),
    onSecondary=Color(0xFF002B36),
    secondaryContainer=Color(0xFF073642),
    onSecondaryContainer=Color(0xFF93A1A1),
    tertiary=Color(0xFF268BD2),
    onTertiary=Color(0xFF002B36),
    tertiaryContainer=Color(0xFF073642),
    onTertiaryContainer=Color(0xFF93A1A1),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF002B36),
    outline=Color(0xFF0E4B59),
    outlineVariant=Color(0xFF073642),
    surface=Color(0xFF002B36),
    onSurface=Color(0xFF93A1A1),
    onSurfaceVariant=Color(0xFF93A1A1),
    surfaceContainerHighest=Color(0xFF0E4B59),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF002B36),
    keyboardContainer=Color(0xFF073642),
    keyboardContainerVariant=Color(0xFF073642).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFF93A1A1),
    keyboardPress=Color(0xFF0E4B59),
    keyboardFade0=Color(0xFF002B36),
    keyboardFade1=Color(0xFF002B36),
    primaryTransparent=Color(0xFF268BD2).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFF93A1A1).copy(alpha = 0.1f),
)

val SolarizedDark = ThemeOption(
    dynamic = false,
    key = "SolarizedDark",
    name = R.string.theme_solarized_dark,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(SolarizedDark)
}
