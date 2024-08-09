package com.makeevrserg.applicationtemplate.mobile.features.theme.data.repository

import com.makeevrserg.applicationtemplate.mobile.features.theme.data.model.Theme
import ru.astrainteractive.klibs.kstorage.api.flow.StateFlowMutableKrate

internal interface ThemeSwitcherRepository {

    val themeFlowStorageValue: StateFlowMutableKrate<Theme>
}
