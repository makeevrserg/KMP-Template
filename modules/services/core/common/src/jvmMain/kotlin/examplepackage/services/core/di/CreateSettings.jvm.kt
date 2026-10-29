package examplepackage.services.core.di

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration
import java.util.prefs.Preferences

internal actual fun createSettings(configuration: PlatformConfiguration): Settings {
    return PreferencesSettings(Preferences.userRoot())
}
