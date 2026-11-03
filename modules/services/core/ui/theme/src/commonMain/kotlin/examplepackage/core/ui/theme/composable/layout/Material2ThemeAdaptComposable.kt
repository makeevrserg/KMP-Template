package examplepackage.core.ui.theme.composable.layout

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import examplepackage.core.ui.theme.theme.Material2Theme

@Composable
internal fun Material2ThemeAdaptComposable(theme: Material2Theme, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = theme.colors,
        typography = theme.typography,
        shapes = theme.shapes,
        content = content
    )
}
