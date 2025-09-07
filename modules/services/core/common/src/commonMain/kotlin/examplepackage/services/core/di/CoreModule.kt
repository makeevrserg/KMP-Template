package examplepackage.services.core.di

import com.russhwolf.settings.Settings
import examplepackage.services.core.di.factory.SettingsFactory
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.serialization.json.Json
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration

interface CoreModule {
    var platformConfigurationInternal: PlatformConfiguration
    val platformConfiguration: PlatformConfiguration
    val jsonConfiguration: Json
    val httpClient: HttpClient
    val settings: Settings
    val dispatchers: KotlinDispatchers
    val mainScope: CoroutineScope

    class Default : CoreModule {
        override lateinit var platformConfigurationInternal: PlatformConfiguration
        override val platformConfiguration: PlatformConfiguration
            get() = platformConfigurationInternal

        override val jsonConfiguration = Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        }

        override val httpClient = HttpClient {
            install(ContentNegotiation) {
                json(jsonConfiguration)
            }
        }

        override val settings by lazy {
            SettingsFactory(platformConfiguration).create()
        }

        override val dispatchers = DefaultKotlinDispatchers

        override val mainScope = MainScope()
    }
}
