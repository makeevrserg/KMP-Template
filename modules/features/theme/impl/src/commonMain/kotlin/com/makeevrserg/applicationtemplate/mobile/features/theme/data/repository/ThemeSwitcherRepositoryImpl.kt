package com.makeevrserg.applicationtemplate.mobile.features.theme.data.repository

import com.makeevrserg.applicationtemplate.mobile.features.theme.data.model.Theme
import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.kstorage.api.impl.DefaultMutableKrate
import ru.astrainteractive.klibs.kstorage.util.asStateFlowMutableKrate

internal class ThemeSwitcherRepositoryImpl(
    private val settings: Settings
) : ThemeSwitcherRepository {

    private val key = "THEME"

    override val themeFlowStorageValue = DefaultMutableKrate(
        factory = { Theme.DARK },
        loader = {
            val ordinal = settings.getInt(key, Theme.LIGHT.ordinal)
            Theme.entries.getOrNull(ordinal)
        },
        saver = { value -> settings.putInt(key, value.ordinal) }
    ).asStateFlowMutableKrate()
}
