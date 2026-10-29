package examplepackage.services.core.di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration

internal actual fun createSettings(configuration: PlatformConfiguration): Settings {
    return StorageSettings()
}
