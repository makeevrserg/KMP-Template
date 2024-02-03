package com.makeevrserg.empireprojekt.mobile.features.root.di.factory

import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import ru.astrainteractive.klibs.kdi.Factory
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration

@Suppress("UnusedPrivateMember")
actual class SettingsFactory actual constructor(
    private val configuration: PlatformConfiguration
) : Factory<Settings> {
    override fun create(): Settings {
        return SharedPreferencesSettings.Factory(configuration.applicationContext).create("SETTINGS")
    }
}
