package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFA6E22E),
    onPrimary=Color(0xFF272822),
    primaryContainer=Color(0xFF3E3D32),
    onPrimaryContainer=Color(0xFFA6E22E),
    secondary=Color(0xFFA6E22E),
    onSecondary=Color(0xFF272822),
    secondaryContainer=Color(0xFF3E3D32),
    onSecondaryContainer=Color(0xFFF8F8F2),
    tertiary=Color(0xFFA6E22E),
    onTertiary=Color(0xFF272822),
    tertiaryContainer=Color(0xFF3E3D32),
    onTertiaryContainer=Color(0xFFF8F8F2),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF272822),
    outline=Color(0xFF49483E),
    outlineVariant=Color(0xFF3E3D32),
    surface=Color(0xFF272822),
    onSurface=Color(0xFFF8F8F2),
    onSurfaceVariant=Color(0xFFF8F8F2),
    surfaceContainerHighest=Color(0xFF49483E),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF272822),
    keyboardContainer=Color(0xFF3E3D32),
    keyboardContainerVariant=Color(0xFF3E3D32).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFF8F8F2),
    keyboardPress=Color(0xFF49483E),
    keyboardFade0=Color(0xFF272822),
    keyboardFade1=Color(0xFF272822),
    primaryTransparent=Color(0xFFA6E22E).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFF8F8F2).copy(alpha = 0.1f),
)

val Monokai = ThemeOption(
    dynamic = false,
    key = "Monokai",
    name = R.string.theme_monokai,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Monokai)
}
