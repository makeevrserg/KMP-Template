package com.makeevrserg.applicationtemplate.mobile.features.theme.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.makeevrserg.applicationtemplate.mobile.core.ui.theme.AdaptThemeFade
import com.makeevrserg.applicationtemplate.mobile.core.ui.theme.ComposeTheme
import com.makeevrserg.applicationtemplate.mobile.features.theme.components.TransparentBars
import com.makeevrserg.applicationtemplate.mobile.features.theme.data.model.Theme
import com.makeevrserg.applicationtemplate.mobile.features.theme.presentation.PreviewThemeSwitcherComponent
import com.makeevrserg.applicationtemplate.mobile.features.theme.presentation.ThemeSwitcherComponent

@Composable
fun ApplicationTheme(
    themeSwitcherComponent: ThemeSwitcherComponent = PreviewThemeSwitcherComponent(),
    content: @Composable () -> Unit
) {
    val theme by themeSwitcherComponent.theme.collectAsState()
    val composeTheme = when (theme) {
        Theme.DARK -> ComposeTheme.DARK
        Theme.LIGHT -> ComposeTheme.LIGHT
    }
    TransparentBars(composeTheme.isDark)

    AdaptThemeFade(composeTheme) {
        content.invoke()
    }
}
