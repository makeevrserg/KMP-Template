package examplepackage.features.theming.api

import examplepackage.features.theming.model.Theme
import ru.astrainteractive.klibs.kstorage.api.StateFlowMutableKrate

internal interface ThemeSwitcherRepository {

    val themeFlowStorageValue: StateFlowMutableKrate<Theme>
}
