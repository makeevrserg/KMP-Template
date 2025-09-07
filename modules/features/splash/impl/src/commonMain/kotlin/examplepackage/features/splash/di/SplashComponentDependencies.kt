package examplepackage.features.splash.di

import examplepackage.features.splash.data.SplashComponentRepository
import examplepackage.features.splash.data.SplashComponentRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import ru.astrainteractive.klibs.kdi.Provider
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

internal interface SplashComponentDependencies {
    val mainScope: CoroutineScope
    val dispatchers: KotlinDispatchers
    val repository: SplashComponentRepository

    class Default(
        override val mainScope: CoroutineScope,
        override val dispatchers: KotlinDispatchers
    ) : SplashComponentDependencies {
        override val repository: SplashComponentRepository = Provider {
            SplashComponentRepositoryImpl()
        }.provide()
    }
}
