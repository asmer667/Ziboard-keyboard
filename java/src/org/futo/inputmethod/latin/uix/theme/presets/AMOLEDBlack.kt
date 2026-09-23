package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFBB86FC),
    onPrimary=Color(0xFF000000),
    primaryContainer=Color(0xFF0A0A0A),
    onPrimaryContainer=Color(0xFFBB86FC),
    secondary=Color(0xFFBB86FC),
    onSecondary=Color(0xFF000000),
    secondaryContainer=Color(0xFF0A0A0A),
    onSecondaryContainer=Color(0xFFEDEDED),
    tertiary=Color(0xFFBB86FC),
    onTertiary=Color(0xFF000000),
    tertiaryContainer=Color(0xFF0A0A0A),
    onTertiaryContainer=Color(0xFFEDEDED),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF000000),
    outline=Color(0xFF1A1A1A),
    outlineVariant=Color(0xFF0A0A0A),
    surface=Color(0xFF000000),
    onSurface=Color(0xFFEDEDED),
    onSurfaceVariant=Color(0xFFEDEDED),
    surfaceContainerHighest=Color(0xFF1A1A1A),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF000000),
    keyboardContainer=Color(0xFF0A0A0A),
    keyboardContainerVariant=Color(0xFF0A0A0A).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFEDEDED),
    keyboardPress=Color(0xFF1A1A1A),
    keyboardFade0=Color(0xFF000000),
    keyboardFade1=Color(0xFF000000),
    primaryTransparent=Color(0xFFBB86FC).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFEDEDED).copy(alpha = 0.1f),
)

val AMOLEDBlack = ThemeOption(
    dynamic = false,
    key = "AMOLEDBlack",
    name = R.string.theme_amoled_black,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(AMOLEDBlack)
}
