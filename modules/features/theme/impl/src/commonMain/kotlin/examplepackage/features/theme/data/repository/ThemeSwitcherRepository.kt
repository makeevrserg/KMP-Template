package examplepackage.features.theme.data.repository

import examplepackage.features.theme.data.model.Theme
import ru.astrainteractive.klibs.kstorage.api.flow.StateFlowMutableKrate

internal interface ThemeSwitcherRepository {

    val themeFlowStorageValue: StateFlowMutableKrate<Theme>
}
