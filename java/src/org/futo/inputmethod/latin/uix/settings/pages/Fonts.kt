package org.futo.inputmethod.latin.uix.settings.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.FONT_KEY
import org.futo.inputmethod.latin.uix.settings.ScreenTitle
import org.futo.inputmethod.latin.uix.settings.ScrollableList
import org.futo.inputmethod.latin.uix.settings.SettingItem
import org.futo.inputmethod.latin.uix.settings.useDataStore
import org.futo.inputmethod.latin.uix.theme.KeyboardFonts
import org.futo.inputmethod.latin.uix.theme.Typography
import org.futo.inputmethod.latin.uix.theme.loadKeyboardFont

@Preview
@Composable
fun FontScreen(navController: NavHostController = rememberNavController()) {
    val context = LocalContext.current
    val (selected, setSelected) = useDataStore(FONT_KEY.key, FONT_KEY.default)

    Column(modifier = Modifier.fillMaxSize()) {
        ScreenTitle(stringResource(R.string.font_settings_title), showBack = true, navController)
        ScrollableList {
            KeyboardFonts.forEach { font ->
                val family = remember(font.key) {
                    loadKeyboardFont(context, font.key)?.let { FontFamily(it) }
                }
                SettingItem(
                    title = font.displayName,
                    onClick = { setSelected(font.key) },
                    icon = {
                        RadioButton(selected = selected == font.key, onClick = null)
                    }
                ) {
                    Text(
                        "AaBbCc 123",
                        style = Typography.Body.Medium.copy(fontFamily = family),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
