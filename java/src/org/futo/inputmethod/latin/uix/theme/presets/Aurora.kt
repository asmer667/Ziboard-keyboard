package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF5CE1B0),
    onPrimary=Color(0xFF10182B),
    primaryContainer=Color(0xFF19233D),
    onPrimaryContainer=Color(0xFF5CE1B0),
    secondary=Color(0xFF5CE1B0),
    onSecondary=Color(0xFF10182B),
    secondaryContainer=Color(0xFF19233D),
    onSecondaryContainer=Color(0xFFD5E4FF),
    tertiary=Color(0xFF5CE1B0),
    onTertiary=Color(0xFF10182B),
    tertiaryContainer=Color(0xFF19233D),
    onTertiaryContainer=Color(0xFFD5E4FF),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF10182B),
    outline=Color(0xFF243352),
    outlineVariant=Color(0xFF19233D),
    surface=Color(0xFF10182B),
    onSurface=Color(0xFFD5E4FF),
    onSurfaceVariant=Color(0xFFD5E4FF),
    surfaceContainerHighest=Color(0xFF243352),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF10182B),
    keyboardContainer=Color(0xFF19233D),
    keyboardContainerVariant=Color(0xFF19233D).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFD5E4FF),
    keyboardPress=Color(0xFF243352),
    keyboardFade0=Color(0xFF10182B),
    keyboardFade1=Color(0xFF10182B),
    primaryTransparent=Color(0xFF5CE1B0).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFD5E4FF).copy(alpha = 0.1f),
)

val Aurora = ThemeOption(
    dynamic = false,
    key = "Aurora",
    name = R.string.theme_aurora,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Aurora)
}
