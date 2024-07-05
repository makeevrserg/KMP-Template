package com.makeevrserg.applicationtemplate.mobile.features.theme.data.repository

import com.makeevrserg.applicationtemplate.mobile.features.theme.data.model.Theme
import ru.astrainteractive.klibs.kstorage.api.StateFlowKrate

internal interface ThemeSwitcherRepository {

    val themeFlowStorageValue: StateFlowKrate.Mutable<Theme>
}
