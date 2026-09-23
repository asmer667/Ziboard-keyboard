package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF7AA2F7),
    onPrimary=Color(0xFF1A1B26),
    primaryContainer=Color(0xFF24283B),
    onPrimaryContainer=Color(0xFF7AA2F7),
    secondary=Color(0xFF7AA2F7),
    onSecondary=Color(0xFF1A1B26),
    secondaryContainer=Color(0xFF24283B),
    onSecondaryContainer=Color(0xFFC0CAF5),
    tertiary=Color(0xFF7AA2F7),
    onTertiary=Color(0xFF1A1B26),
    tertiaryContainer=Color(0xFF24283B),
    onTertiaryContainer=Color(0xFFC0CAF5),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF1A1B26),
    outline=Color(0xFF414868),
    outlineVariant=Color(0xFF24283B),
    surface=Color(0xFF1A1B26),
    onSurface=Color(0xFFC0CAF5),
    onSurfaceVariant=Color(0xFFC0CAF5),
    surfaceContainerHighest=Color(0xFF414868),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF1A1B26),
    keyboardContainer=Color(0xFF24283B),
    keyboardContainerVariant=Color(0xFF24283B).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFC0CAF5),
    keyboardPress=Color(0xFF414868),
    keyboardFade0=Color(0xFF1A1B26),
    keyboardFade1=Color(0xFF1A1B26),
    primaryTransparent=Color(0xFF7AA2F7).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFC0CAF5).copy(alpha = 0.1f),
)

val TokyoNight = ThemeOption(
    dynamic = false,
    key = "TokyoNight",
    name = R.string.theme_tokyo_night,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(TokyoNight)
}
