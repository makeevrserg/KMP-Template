package examplepackage.features.theming.api

import examplepackage.features.theming.model.Theme
import kotlinx.coroutines.flow.StateFlow

interface ThemeSwitcherComponent {
    val theme: StateFlow<Theme>

    fun selectDarkTheme()
    fun selectLightTheme()
    fun selectTheme(theme: Theme)
    fun next()
}
