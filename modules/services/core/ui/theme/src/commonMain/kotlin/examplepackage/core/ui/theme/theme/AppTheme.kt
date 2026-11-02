package examplepackage.core.ui.theme.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val DefaultDimens = AppTheme.Dimens()

class AppTheme(
    val dimens: Dimens = DefaultDimens,
    val customColors: CustomColors = CustomColors.Companion.Dark
) {
    // Theme spacing is configurable as a single set of tokens.
    @Suppress("ConstructorParameterNaming", "LongParameterList")
    class Dimens(
        val XXS: Dp = 4.dp,
        val XS: Dp = 8.dp,
        val S: Dp = 16.dp,
        val M: Dp = 21.dp,
        val L: Dp = 32.dp,
        val SXL: Dp = 40.dp,
        val XL: Dp = 48.dp,
        val XXL: Dp = 64.dp,
    )
}
