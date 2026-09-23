package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

private val colorScheme = extendedDarkColorScheme(
    primary=Color(0xFF61AFEF),
    onPrimary=Color(0xFF282C34),
    primaryContainer=Color(0xFF2C313A),
    onPrimaryContainer=Color(0xFF61AFEF),
    secondary=Color(0xFF61AFEF),
    onSecondary=Color(0xFF282C34),
    secondaryContainer=Color(0xFF2C313A),
    onSecondaryContainer=Color(0xFFABB2BF),
    tertiary=Color(0xFF61AFEF),
    onTertiary=Color(0xFF282C34),
    tertiaryContainer=Color(0xFF2C313A),
    onTertiaryContainer=Color(0xFFABB2BF),
    error=Color(0xFFF38BA8),
    onError=Color(0xFF3A121E),
    errorContainer=Color(0xFFF38BA8),
    onErrorContainer=Color(0xFF282C34),
    outline=Color(0xFF3E4451),
    outlineVariant=Color(0xFF2C313A),
    surface=Color(0xFF282C34),
    onSurface=Color(0xFFABB2BF),
    onSurfaceVariant=Color(0xFFABB2BF),
    surfaceContainerHighest=Color(0xFF3E4451),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF282C34),
    keyboardContainer=Color(0xFF2C313A),
    keyboardContainerVariant=Color(0xFF2C313A).copy(alpha = 0.4f),
    onKeyboardContainer=Color(0xFFABB2BF),
    keyboardPress=Color(0xFF3E4451),
    keyboardFade0=Color(0xFF282C34),
    keyboardFade1=Color(0xFF282C34),
    primaryTransparent=Color(0xFF61AFEF).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFABB2BF).copy(alpha = 0.1f),
)

val OneDark = ThemeOption(
    dynamic = false,
    key = "OneDark",
    name = R.string.theme_one_dark,
    available = { true }
) {
    colorScheme
}

@Composable
@Preview
private fun PreviewTheme() {
    ThemePreview(OneDark)
}
