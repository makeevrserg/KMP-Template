package examplepackage.core.ui.theme

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

@Suppress("ComposableNaming", "CompositionLocalAllowlist")
val LocalAppTheme: ProvidableCompositionLocal<AppTheme> = compositionLocalOf {
    AppTheme()
}
