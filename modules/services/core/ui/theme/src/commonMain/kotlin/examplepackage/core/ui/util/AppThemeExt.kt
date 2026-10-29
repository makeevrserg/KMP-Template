package examplepackage.core.ui.util

import examplepackage.core.ui.model.ComposeTheme
import examplepackage.core.ui.theme.AppTheme
import examplepackage.core.ui.theme.CustomColors
import examplepackage.core.ui.theme.Dark
import examplepackage.core.ui.theme.Light
import examplepackage.core.ui.theme.Material2Theme
import examplepackage.core.ui.theme.Material3Theme

internal fun AppTheme.asMaterial2(): Material2Theme {
    return Material2Theme(
        colors = customColors.asMaterial2(),
    )
}

internal fun AppTheme.asMaterial3(): Material3Theme {
    return Material3Theme(
        colorScheme = customColors.asMaterial3(),
    )
}

internal fun ComposeTheme.resolveAppTheme(): AppTheme {
    val customColors = when (this) {
        ComposeTheme.DARK -> CustomColors.Dark
        ComposeTheme.LIGHT -> CustomColors.Light
    }
    return AppTheme(customColors = customColors)
}
