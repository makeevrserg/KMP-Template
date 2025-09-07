@file:Suppress("MatchingDeclarationName")

package examplepackage.services.core.di.factory

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration
import java.util.prefs.Preferences

@Suppress("UnusedPrivateMember")
internal actual class SettingsFactory actual constructor(
    private val configuration: PlatformConfiguration
) {
    actual fun create(): Settings {
        return PreferencesSettings(Preferences.userRoot())
    }
}
