package org.futo.inputmethod.latin.uix.settings.pages.credits

data class Contributor(
    val name: String,
    val avatarUrl: String? = null,
    val profileUrl: String? = null
)

val CONTRIBUTORS_LIST: List<Contributor> = emptyList()
