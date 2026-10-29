package examplepackage.features.splash.di

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.splash.api.SplashComponentRepository
import examplepackage.features.splash.component.DefaultSplashComponent
import examplepackage.features.splash.component.SplashComponent
import examplepackage.features.splash.memory.InMemorySplashComponentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

interface SplashModule {
    fun createSplashComponent(componentContext: ComponentContext): SplashComponent

    class Default(
        private val mainScope: CoroutineScope,
        private val dispatchers: KotlinDispatchers
    ) : SplashModule {
        private val repository: SplashComponentRepository = InMemorySplashComponentRepository()

        override fun createSplashComponent(componentContext: ComponentContext): SplashComponent {
            return DefaultSplashComponent(
                componentContext = componentContext,
                mainScope = mainScope,
                dispatchers = dispatchers,
                repository = repository
            )
        }
    }

    class Preview : SplashModule {
        private val repository = object : SplashComponentRepository {
            override fun isInitialLaunch(): Boolean = true
        }

        override fun createSplashComponent(componentContext: ComponentContext): SplashComponent {
            return DefaultSplashComponent(
                componentContext = componentContext,
                mainScope = MainScope(),
                dispatchers = DefaultKotlinDispatchers,
                repository = repository
            )
        }
    }
}
