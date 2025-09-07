package examplepackage.services.core.di.factory

import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration

internal expect class SettingsFactory(
    configuration: PlatformConfiguration
) {
    fun create(): Settings
}
