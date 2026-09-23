package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFBD93F9),
    onPrimary=Color(0xFF282A36),
    primaryContainer=Color(0xFF343746),
    onPrimaryContainer=Color(0xFFBD93F9),
    secondary=Color(0xFFBD93F9),
    onSecondary=Color(0xFF282A36),
    secondaryContainer=Color(0xFF343746),
    onSecondaryContainer=Color(0xFFF8F8F2),
    tertiary=Color(0xFFBD93F9),
    onTertiary=Color(0xFF282A36),
    tertiaryContainer=Color(0xFF343746),
    onTertiaryContainer=Color(0xFFF8F8F2),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF282A36),
    outline=Color(0xFF44475A),
    outlineVariant=Color(0xFF343746),
    surface=Color(0xFF282A36),
    onSurface=Color(0xFFF8F8F2),
    onSurfaceVariant=Color(0xFFF8F8F2),
    surfaceContainerHighest=Color(0xFF44475A),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF282A36),
    keyboardContainer=Color(0xFF343746),
    keyboardContainerVariant=Color(0xFF343746).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFF8F8F2),
    keyboardPress=Color(0xFF44475A),
    keyboardFade0=Color(0xFF282A36),
    keyboardFade1=Color(0xFF282A36),
    primaryTransparent=Color(0xFFBD93F9).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFF8F8F2).copy(alpha = 0.1f),
)

val Dracula = ThemeOption(
    dynamic = false,
    key = "Dracula",
    name = R.string.theme_dracula,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Dracula)
}
