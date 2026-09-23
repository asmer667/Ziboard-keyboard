package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFFCEE0A),
    onPrimary=Color(0xFF0D0221),
    primaryContainer=Color(0xFF1A0938),
    onPrimaryContainer=Color(0xFFFCEE0A),
    secondary=Color(0xFFFCEE0A),
    onSecondary=Color(0xFF0D0221),
    secondaryContainer=Color(0xFF1A0938),
    onSecondaryContainer=Color(0xFF00F0FF),
    tertiary=Color(0xFFFCEE0A),
    onTertiary=Color(0xFF0D0221),
    tertiaryContainer=Color(0xFF1A0938),
    onTertiaryContainer=Color(0xFF00F0FF),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF0D0221),
    outline=Color(0xFF261447),
    outlineVariant=Color(0xFF1A0938),
    surface=Color(0xFF0D0221),
    onSurface=Color(0xFF00F0FF),
    onSurfaceVariant=Color(0xFF00F0FF),
    surfaceContainerHighest=Color(0xFF261447),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF0D0221),
    keyboardContainer=Color(0xFF1A0938),
    keyboardContainerVariant=Color(0xFF1A0938).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFF00F0FF),
    keyboardPress=Color(0xFF261447),
    keyboardFade0=Color(0xFF0D0221),
    keyboardFade1=Color(0xFF0D0221),
    primaryTransparent=Color(0xFFFCEE0A).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFF00F0FF).copy(alpha = 0.1f),
)

val Cyberpunk = ThemeOption(
    dynamic = false,
    key = "Cyberpunk",
    name = R.string.theme_cyberpunk,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Cyberpunk)
}
