package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF7CB342),
    onPrimary=Color(0xFF1B2A20),
    primaryContainer=Color(0xFF243A2C),
    onPrimaryContainer=Color(0xFF7CB342),
    secondary=Color(0xFF7CB342),
    onSecondary=Color(0xFF1B2A20),
    secondaryContainer=Color(0xFF243A2C),
    onSecondaryContainer=Color(0xFFDDE8DD),
    tertiary=Color(0xFF7CB342),
    onTertiary=Color(0xFF1B2A20),
    tertiaryContainer=Color(0xFF243A2C),
    onTertiaryContainer=Color(0xFFDDE8DD),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF1B2A20),
    outline=Color(0xFF32503B),
    outlineVariant=Color(0xFF243A2C),
    surface=Color(0xFF1B2A20),
    onSurface=Color(0xFFDDE8DD),
    onSurfaceVariant=Color(0xFFDDE8DD),
    surfaceContainerHighest=Color(0xFF32503B),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF1B2A20),
    keyboardContainer=Color(0xFF243A2C),
    keyboardContainerVariant=Color(0xFF243A2C).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFDDE8DD),
    keyboardPress=Color(0xFF32503B),
    keyboardFade0=Color(0xFF1B2A20),
    keyboardFade1=Color(0xFF1B2A20),
    primaryTransparent=Color(0xFF7CB342).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFDDE8DD).copy(alpha = 0.1f),
)

val Forest = ThemeOption(
    dynamic = false,
    key = "Forest",
    name = R.string.theme_forest,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Forest)
}
