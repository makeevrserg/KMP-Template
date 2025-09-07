package examplepackage.features.theme.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import examplepackage.core.ui.theme.AdaptThemeFade
import examplepackage.core.ui.theme.ComposeTheme
import examplepackage.features.theme.components.TransparentBars
import examplepackage.features.theme.data.model.Theme
import examplepackage.features.theme.presentation.PreviewThemeSwitcherComponent
import examplepackage.features.theme.presentation.ThemeSwitcherComponent

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
