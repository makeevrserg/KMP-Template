package examplepackage.core.ui.theme.composable.layout

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import examplepackage.core.ui.theme.model.ComposeTheme
import examplepackage.core.ui.theme.theme.LocalAppTheme
import examplepackage.core.ui.theme.util.asMaterial2
import examplepackage.core.ui.theme.util.asMaterial3
import examplepackage.core.ui.theme.util.resolveAppTheme

@Composable
fun AdaptThemeFadeComposable(
    composeTheme: ComposeTheme = ComposeTheme.DARK,
    content: @Composable () -> Unit
) {
    val appTheme = composeTheme.resolveAppTheme()
    Crossfade(targetState = appTheme) { appTheme ->
        CompositionLocalProvider(
            LocalAppTheme provides appTheme,
            content = {
                Material2ThemeAdaptComposable(theme = LocalAppTheme.current.asMaterial2()) {
                    Material3ThemeAdaptComposable(theme = LocalAppTheme.current.asMaterial3()) {
                        content.invoke()
                    }
                }
            }
        )
    }
}
