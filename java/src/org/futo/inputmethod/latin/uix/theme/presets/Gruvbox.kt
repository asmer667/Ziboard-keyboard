package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFFABD2F),
    onPrimary=Color(0xFF282828),
    primaryContainer=Color(0xFF3C3836),
    onPrimaryContainer=Color(0xFFFABD2F),
    secondary=Color(0xFFFABD2F),
    onSecondary=Color(0xFF282828),
    secondaryContainer=Color(0xFF3C3836),
    onSecondaryContainer=Color(0xFFEBDBB2),
    tertiary=Color(0xFFFABD2F),
    onTertiary=Color(0xFF282828),
    tertiaryContainer=Color(0xFF3C3836),
    onTertiaryContainer=Color(0xFFEBDBB2),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF282828),
    outline=Color(0xFF504945),
    outlineVariant=Color(0xFF3C3836),
    surface=Color(0xFF282828),
    onSurface=Color(0xFFEBDBB2),
    onSurfaceVariant=Color(0xFFEBDBB2),
    surfaceContainerHighest=Color(0xFF504945),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF282828),
    keyboardContainer=Color(0xFF3C3836),
    keyboardContainerVariant=Color(0xFF3C3836).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFEBDBB2),
    keyboardPress=Color(0xFF504945),
    keyboardFade0=Color(0xFF282828),
    keyboardFade1=Color(0xFF282828),
    primaryTransparent=Color(0xFFFABD2F).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFEBDBB2).copy(alpha = 0.1f),
)

val Gruvbox = ThemeOption(
    dynamic = false,
    key = "Gruvbox",
    name = R.string.theme_gruvbox,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Gruvbox)
}
