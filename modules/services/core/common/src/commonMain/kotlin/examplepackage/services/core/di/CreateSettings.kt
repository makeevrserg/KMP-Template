package examplepackage.services.core.di

import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration

internal expect fun createSettings(configuration: PlatformConfiguration): Settings
