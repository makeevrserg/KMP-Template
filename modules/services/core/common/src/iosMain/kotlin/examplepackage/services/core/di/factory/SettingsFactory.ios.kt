@file:Suppress("MatchingDeclarationName")

package examplepackage.services.core.di.factory

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration

@Suppress("UnusedPrivateMember")
internal actual class SettingsFactory actual constructor(
    private val configuration: PlatformConfiguration
) {
    actual fun create(): Settings {
        return NSUserDefaultsSettings.Factory().create("SETTINGS")
    }
}
