package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFA7C080),
    onPrimary=Color(0xFF2D353B),
    primaryContainer=Color(0xFF374247),
    onPrimaryContainer=Color(0xFFA7C080),
    secondary=Color(0xFFA7C080),
    onSecondary=Color(0xFF2D353B),
    secondaryContainer=Color(0xFF374247),
    onSecondaryContainer=Color(0xFFD3C6AA),
    tertiary=Color(0xFFA7C080),
    onTertiary=Color(0xFF2D353B),
    tertiaryContainer=Color(0xFF374247),
    onTertiaryContainer=Color(0xFFD3C6AA),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF2D353B),
    outline=Color(0xFF475258),
    outlineVariant=Color(0xFF374247),
    surface=Color(0xFF2D353B),
    onSurface=Color(0xFFD3C6AA),
    onSurfaceVariant=Color(0xFFD3C6AA),
    surfaceContainerHighest=Color(0xFF475258),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF2D353B),
    keyboardContainer=Color(0xFF374247),
    keyboardContainerVariant=Color(0xFF374247).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFD3C6AA),
    keyboardPress=Color(0xFF475258),
    keyboardFade0=Color(0xFF2D353B),
    keyboardFade1=Color(0xFF2D353B),
    primaryTransparent=Color(0xFFA7C080).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFD3C6AA).copy(alpha = 0.1f),
)

val Everforest = ThemeOption(
    dynamic = false,
    key = "Everforest",
    name = R.string.theme_everforest,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Everforest)
}
