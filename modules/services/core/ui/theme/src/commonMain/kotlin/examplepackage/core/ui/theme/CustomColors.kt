package examplepackage.core.ui.theme

import androidx.compose.ui.graphics.Color

data class CustomColors(
    val surface: Surface,
    val action: Action,
    val astraLogo: AstraLogo,
    val isDark: Boolean
) {
    data class AstraLogo(
        val astraRed: Color,
        val astraBlue: Color,
        val astraOrange: Color,
        val astraYellow: Color,
    )

    data class Action(
        val colorNegative: Color,
        val colorPositive: Color,
    )

    data class Surface(
        val primary: Color,
        val onPrimary: Color,
        val primaryVariant: Color,
        val onPrimaryVariant: Color,
        val secondary: Color,
        val onSecondary: Color,
        val secondaryVariant: Color,
        val onSecondaryVariant: Color
    )

    companion object
}

internal val CustomColors.Companion.Dark: CustomColors
    get() = CustomColors(
        isDark = true,
        surface = CustomColors.Surface(
            primary = Color(color = 0xFF1F252C),
            onPrimary = Color(color = 0xFFFFFEFD),
            primaryVariant = Color(color = 0xFF151C1F),
            onPrimaryVariant = Color(color = 0xFFFFFEFD),
            secondary = Color(color = 0xFFFFC100),
            onSecondary = Color(color = 0xFF59626D),
            secondaryVariant = Color(color = 0xFF1B76CA),
            onSecondaryVariant = Color(color = 0xFFFFFEFD)
        ),
        action = CustomColors.Action(
            colorNegative = Color(color = 0xFF8D2E2E),
            colorPositive = Color(color = 0xFF3C7C42)
        ),
        astraLogo = CustomColors.AstraLogo(
            astraRed = Color(color = 0xFFbc2551),
            astraBlue = Color(color = 0xFF304d7b),
            astraOrange = Color(color = 0xFFd34829),
            astraYellow = Color(color = 0xFFDA8D2C),
        )
    )

internal val CustomColors.Companion.Light: CustomColors
    get() = CustomColors(
        isDark = false,
        surface = CustomColors.Surface(
            primary = Color(color = 0xFFFFFFFF),
            onPrimary = Color(color = 0xFF181818),
            primaryVariant = Color(color = 0xFFF1F1F1),
            onPrimaryVariant = Color(color = 0xFFFFFFFF),
            secondary = Color(color = 0xFFFFC100),
            onSecondary = Color(color = 0xFF4E5C66),
            secondaryVariant = Color(color = 0xFF1B76CA),
            onSecondaryVariant = Color(color = 0xFFFFFFFF)
        ),
        action = CustomColors.Action(
            colorNegative = Color(color = 0xFF8D2E2E),
            colorPositive = Color(color = 0xFF3C7C42)
        ),
        astraLogo = CustomColors.AstraLogo(
            astraRed = Color(color = 0xFFbc2551),
            astraBlue = Color(color = 0xFF304d7b),
            astraOrange = Color(color = 0xFFd34829),
            astraYellow = Color(color = 0xFFDA8D2C),
        )
    )
