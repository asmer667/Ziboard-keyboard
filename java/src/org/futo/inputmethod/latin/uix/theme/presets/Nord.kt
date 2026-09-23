package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF88C0D0),
    onPrimary=Color(0xFF2E3440),
    primaryContainer=Color(0xFF3B4252),
    onPrimaryContainer=Color(0xFF88C0D0),
    secondary=Color(0xFF88C0D0),
    onSecondary=Color(0xFF2E3440),
    secondaryContainer=Color(0xFF3B4252),
    onSecondaryContainer=Color(0xFFECEFF4),
    tertiary=Color(0xFF88C0D0),
    onTertiary=Color(0xFF2E3440),
    tertiaryContainer=Color(0xFF3B4252),
    onTertiaryContainer=Color(0xFFECEFF4),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF2E3440),
    outline=Color(0xFF434C5E),
    outlineVariant=Color(0xFF3B4252),
    surface=Color(0xFF2E3440),
    onSurface=Color(0xFFECEFF4),
    onSurfaceVariant=Color(0xFFECEFF4),
    surfaceContainerHighest=Color(0xFF434C5E),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF2E3440),
    keyboardContainer=Color(0xFF3B4252),
    keyboardContainerVariant=Color(0xFF3B4252).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFECEFF4),
    keyboardPress=Color(0xFF434C5E),
    keyboardFade0=Color(0xFF2E3440),
    keyboardFade1=Color(0xFF2E3440),
    primaryTransparent=Color(0xFF88C0D0).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFECEFF4).copy(alpha = 0.1f),
)

val Nord = ThemeOption(
    dynamic = false,
    key = "Nord",
    name = R.string.theme_nord,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Nord)
}
