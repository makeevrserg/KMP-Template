package com.makeevrserg.applicationtemplate.mobile.services.core.di

import com.makeevrserg.applicationtemplate.mobile.services.core.di.factory.SettingsFactory
import com.russhwolf.settings.Settings
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.serialization.json.Json
import ru.astrainteractive.klibs.kdi.Lateinit
import ru.astrainteractive.klibs.kdi.Single
import ru.astrainteractive.klibs.kdi.getValue
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers
import ru.astrainteractive.klibs.mikro.platform.PlatformConfiguration

interface CoreModule {

    val platformConfiguration: Lateinit<PlatformConfiguration>
    val jsonConfiguration: Single<Json>
    val httpClient: Single<HttpClient>
    val settings: Single<Settings>
    val dispatchers: Single<KotlinDispatchers>
    val mainScope: Single<CoroutineScope>

    class Default : CoreModule {

        override val platformConfiguration = Lateinit<PlatformConfiguration>()

        override val jsonConfiguration = Single {
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        }

        override val httpClient = Single {
            val jsonConfiguration by jsonConfiguration
            HttpClient {
                install(ContentNegotiation) {
                    json(jsonConfiguration)
                }
            }
        }

        override val settings = Single {
            val configuration by platformConfiguration
            SettingsFactory(configuration).create()
        }

        override val dispatchers = Single<KotlinDispatchers> {
            DefaultKotlinDispatchers
        }

        override val mainScope = Single {
            MainScope()
        }
    }
}
