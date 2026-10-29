package examplepackage.services.core.di

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration

internal actual fun createSettings(configuration: PlatformConfiguration): Settings {
    return NSUserDefaultsSettings.Factory().create("SETTINGS")
}
