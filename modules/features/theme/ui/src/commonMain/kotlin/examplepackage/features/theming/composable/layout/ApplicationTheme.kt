package examplepackage.features.theming.composable.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import examplepackage.core.ui.composable.layout.AdaptThemeFade
import examplepackage.core.ui.model.ComposeTheme
import examplepackage.features.theming.api.ThemeSwitcherComponent
import examplepackage.features.theming.model.Theme

@Composable
fun ApplicationTheme(
    themeSwitcherComponent: ThemeSwitcherComponent,
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
