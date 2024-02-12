package com.makeevrserg.applicationtemplate.mobile.features.theme.presentation

import com.makeevrserg.applicationtemplate.mobile.features.theme.data.model.Theme
import kotlinx.coroutines.flow.StateFlow

interface ThemeSwitcherComponent {
    val theme: StateFlow<Theme>

    fun selectDarkTheme()
    fun selectLightTheme()
    fun selectTheme(theme: Theme)
    fun next()
}
