package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF6C8EEF),
    onPrimary=Color(0xFF0A0E1A),
    primaryContainer=Color(0xFF131A2B),
    onPrimaryContainer=Color(0xFF6C8EEF),
    secondary=Color(0xFF6C8EEF),
    onSecondary=Color(0xFF0A0E1A),
    secondaryContainer=Color(0xFF131A2B),
    onSecondaryContainer=Color(0xFFD3DAEA),
    tertiary=Color(0xFF6C8EEF),
    onTertiary=Color(0xFF0A0E1A),
    tertiaryContainer=Color(0xFF131A2B),
    onTertiaryContainer=Color(0xFFD3DAEA),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF0A0E1A),
    outline=Color(0xFF1E2842),
    outlineVariant=Color(0xFF131A2B),
    surface=Color(0xFF0A0E1A),
    onSurface=Color(0xFFD3DAEA),
    onSurfaceVariant=Color(0xFFD3DAEA),
    surfaceContainerHighest=Color(0xFF1E2842),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF0A0E1A),
    keyboardContainer=Color(0xFF131A2B),
    keyboardContainerVariant=Color(0xFF131A2B).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFD3DAEA),
    keyboardPress=Color(0xFF1E2842),
    keyboardFade0=Color(0xFF0A0E1A),
    keyboardFade1=Color(0xFF0A0E1A),
    primaryTransparent=Color(0xFF6C8EEF).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFD3DAEA).copy(alpha = 0.1f),
)

val Midnight = ThemeOption(
    dynamic = false,
    key = "Midnight",
    name = R.string.theme_midnight,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Midnight)
}
