@file:Suppress("MatchingDeclarationName")

package com.makeevrserg.applicationtemplate.mobile.services.core.di.factory

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.kdi.Factory
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration
import java.util.prefs.Preferences

@Suppress("UnusedPrivateMember")
internal actual class SettingsFactory actual constructor(
    private val configuration: PlatformConfiguration
) : Factory<Settings> {
    override fun create(): Settings {
        return PreferencesSettings(Preferences.userRoot())
    }
}
