package org.futo.inputmethod.latin.uix.settings.pages

import androidx.compose.ui.res.stringResource
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.settings.Settings
import org.futo.inputmethod.latin.uix.settings.Tip
import org.futo.inputmethod.latin.uix.settings.UserSettingsMenu
import org.futo.inputmethod.latin.uix.settings.userSettingDecorationOnly
import org.futo.inputmethod.latin.uix.settings.userSettingToggleSharedPrefs

val PrivacyMenu = UserSettingsMenu(
    title = R.string.privacy_settings_title,
    navPath = "privacy", registerNavPath = true,
    settings = listOf(
        userSettingToggleSharedPrefs(
            title = R.string.privacy_incognito_mode,
            subtitle = R.string.privacy_incognito_mode_summary,
            key = Settings.PREF_KEY_INCOGNITO_MODE,
            default = { false }
        ),

        userSettingToggleSharedPrefs(
            title = R.string.use_personalized_dicts,
            subtitle = R.string.use_personalized_dicts_summary,
            key = Settings.PREF_KEY_USE_PERSONALIZED_DICTS,
            default = { true }
        ),

        userSettingDecorationOnly { Tip(stringResource(R.string.privacy_offline_notice)) },
    )
)
