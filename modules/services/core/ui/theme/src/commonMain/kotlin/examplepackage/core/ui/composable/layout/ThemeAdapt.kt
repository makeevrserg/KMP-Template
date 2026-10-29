package examplepackage.core.ui.composable.layout

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import examplepackage.core.ui.model.ComposeTheme
import examplepackage.core.ui.theme.LocalAppTheme
import examplepackage.core.ui.theme.Material2Theme
import examplepackage.core.ui.theme.Material3Theme
import examplepackage.core.ui.util.asMaterial2
import examplepackage.core.ui.util.asMaterial3
import examplepackage.core.ui.util.resolveAppTheme

@Composable
private fun Material3ThemeAdapt(theme: Material3Theme, content: @Composable () -> Unit) {
    androidx.compose.material3.MaterialTheme(
        colorScheme = theme.colorScheme,
        shapes = theme.shapes,
        typography = theme.typography,
        content = content
    )
}

@Composable
private fun Material2ThemeAdapt(theme: Material2Theme, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = theme.colors,
        typography = theme.typography,
        shapes = theme.shapes,
        content = content
    )
}

@Composable
fun AdaptThemeFade(
    composeTheme: ComposeTheme = ComposeTheme.DARK,
    content: @Composable () -> Unit
) {
    val appTheme = composeTheme.resolveAppTheme()
    Crossfade(targetState = appTheme) { appTheme ->
        CompositionLocalProvider(
            LocalAppTheme provides appTheme,
            content = {
                Material2ThemeAdapt(theme = LocalAppTheme.current.asMaterial2()) {
                    Material3ThemeAdapt(theme = LocalAppTheme.current.asMaterial3()) {
                        content.invoke()
                    }
                }
            }
        )
    }
}
