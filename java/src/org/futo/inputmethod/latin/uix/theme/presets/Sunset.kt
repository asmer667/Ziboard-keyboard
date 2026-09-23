package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFFF7043),
    onPrimary=Color(0xFF2A1A22),
    primaryContainer=Color(0xFF3A222E),
    onPrimaryContainer=Color(0xFFFF7043),
    secondary=Color(0xFFFF7043),
    onSecondary=Color(0xFF2A1A22),
    secondaryContainer=Color(0xFF3A222E),
    onSecondaryContainer=Color(0xFFFCE4D6),
    tertiary=Color(0xFFFF7043),
    onTertiary=Color(0xFF2A1A22),
    tertiaryContainer=Color(0xFF3A222E),
    onTertiaryContainer=Color(0xFFFCE4D6),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF2A1A22),
    outline=Color(0xFF4E2E3D),
    outlineVariant=Color(0xFF3A222E),
    surface=Color(0xFF2A1A22),
    onSurface=Color(0xFFFCE4D6),
    onSurfaceVariant=Color(0xFFFCE4D6),
    surfaceContainerHighest=Color(0xFF4E2E3D),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF2A1A22),
    keyboardContainer=Color(0xFF3A222E),
    keyboardContainerVariant=Color(0xFF3A222E).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFFCE4D6),
    keyboardPress=Color(0xFF4E2E3D),
    keyboardFade0=Color(0xFF2A1A22),
    keyboardFade1=Color(0xFF2A1A22),
    primaryTransparent=Color(0xFFFF7043).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFFCE4D6).copy(alpha = 0.1f),
)

val Sunset = ThemeOption(
    dynamic = false,
    key = "Sunset",
    name = R.string.theme_sunset,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Sunset)
}
