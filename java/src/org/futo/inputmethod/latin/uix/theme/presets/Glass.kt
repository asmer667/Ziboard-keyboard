package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFFB0E0FF),
    onPrimary=Color(0xFF10202E),
    primaryContainer=Color(0xFFFFFFFF).copy(alpha = 0.14f),
    onPrimaryContainer=Color(0xFFEAF6FF),
    secondary=Color(0xFFCFE8FF),
    onSecondary=Color(0xFF16242E),
    secondaryContainer=Color(0xFFFFFFFF).copy(alpha = 0.10f),
    onSecondaryContainer=Color(0xFFEAF6FF),
    tertiary=Color(0xFFBFD9FF),
    onTertiary=Color(0xFF16202E),
    tertiaryContainer=Color(0xFFFFFFFF).copy(alpha = 0.10f),
    onTertiaryContainer=Color(0xFFEAF6FF),
    error=Color(0xFFFF8C80),
    onError=Color(0xFF4D2B2B),
    errorContainer=Color(0xFF803B3B),
    onErrorContainer=Color(0xFFFFDFDB),
    outline=Color(0xFFFFFFFF).copy(alpha = 0.28f),
    outlineVariant=Color(0xFFFFFFFF).copy(alpha = 0.12f),
    surface=Color(0xFF12151C),
    onSurface=Color(0xFFF2F6FF),
    onSurfaceVariant=Color(0xFFDCE4F0),
    surfaceContainerHighest=Color(0xFFFFFFFF).copy(alpha = 0.18f),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF12151C),
    keyboardContainer=Color(0xFFFFFFFF).copy(alpha = 0.16f),
    keyboardContainerVariant=Color(0xFFFFFFFF).copy(alpha = 0.07f),
    onKeyboardContainer=Color(0xFFFFFFFF),
    keyboardPress=Color(0xFFFFFFFF).copy(alpha = 0.30f),
    keyboardFade0=Color(0xFF1B2436),
    keyboardFade1=Color(0xFF0E1220),
    keyboardBackgroundGradient = Brush.verticalGradient(
        0.0f to Color(0xFF243B55),
        1.0f to Color(0xFF141E2E)
    ),
    primaryTransparent=Color(0xFFB0E0FF).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFF2F6FF).copy(alpha = 0.1f),
    navigationBarColor = Color(0xFF141E2E),
    navigationBarColorForTransparency = Color(0xFF000000),
)

val Glass = ThemeOption(
    dynamic = false,
    key = "Glass",
    name = R.string.theme_glass,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(Glass)
}
