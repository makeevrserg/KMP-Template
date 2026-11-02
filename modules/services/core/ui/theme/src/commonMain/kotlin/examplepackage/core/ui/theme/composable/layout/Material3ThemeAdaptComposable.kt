package examplepackage.core.ui.theme.composable.layout

import androidx.compose.runtime.Composable
import examplepackage.core.ui.theme.theme.Material3Theme

@Composable
internal fun Material3ThemeAdaptComposable(theme: Material3Theme, content: @Composable () -> Unit) {
    androidx.compose.material3.MaterialTheme(
        colorScheme = theme.colorScheme,
        shapes = theme.shapes,
        typography = theme.typography,
        content = content
    )
}
