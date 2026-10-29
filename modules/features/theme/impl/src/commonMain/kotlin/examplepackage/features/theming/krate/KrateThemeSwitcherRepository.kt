package examplepackage.features.theming.krate

import com.russhwolf.settings.Settings
import examplepackage.features.theming.api.ThemeSwitcherRepository
import examplepackage.features.theming.model.Theme
import ru.astrainteractive.klibs.kstorage.api.asStateFlowMutableKrate
import ru.astrainteractive.klibs.kstorage.api.impl.DefaultMutableKrate

private const val THEME_KEY = "THEME"

internal class KrateThemeSwitcherRepository(
    private val settings: Settings
) : ThemeSwitcherRepository {

    override val themeFlowStorageValue = DefaultMutableKrate(
        factory = { Theme.DARK },
        loader = {
            val ordinal = settings.getInt(THEME_KEY, Theme.LIGHT.ordinal)
            Theme.entries.getOrNull(ordinal)
        },
        saver = { value -> settings.putInt(THEME_KEY, value.ordinal) }
    ).asStateFlowMutableKrate()
}
