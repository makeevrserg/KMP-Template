package examplepackage.core.ui.theme.composable.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
actual fun TransparentBarsComposable(isDarkTheme: Boolean) {
    val systemUiController = rememberSystemUiController()
    DisposableEffect(
        systemUiController,
        isDarkTheme
    ) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !isDarkTheme
        )
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = !isDarkTheme
        )
        systemUiController.setNavigationBarColor(
            color = Color.Transparent,
            darkIcons = !isDarkTheme
        )
        onDispose {}
    }
}
