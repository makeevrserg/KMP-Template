package examplepackage.features.splash.impl.di

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.splash.api.component.SplashComponent
import examplepackage.features.splash.impl.api.SplashComponentRepository
import examplepackage.features.splash.impl.component.DefaultSplashComponent
import examplepackage.features.splash.impl.memory.InMemorySplashComponentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

interface SplashModule : SplashComponent.Factory {

    class Default(
        private val mainScope: CoroutineScope,
        private val dispatchers: KotlinDispatchers
    ) : SplashModule {
        private val repository: SplashComponentRepository = InMemorySplashComponentRepository()

        override fun invoke(componentContext: ComponentContext): SplashComponent {
            return DefaultSplashComponent(
                componentContext = componentContext,
                mainScope = mainScope,
                dispatchers = dispatchers,
                repository = repository
            )
        }
    }

    class Preview : SplashModule {
        private val repository: SplashComponentRepository = InMemorySplashComponentRepository()

        override fun invoke(componentContext: ComponentContext): SplashComponent {
            return DefaultSplashComponent(
                componentContext = componentContext,
                mainScope = MainScope(),
                dispatchers = DefaultKotlinDispatchers,
                repository = repository
            )
        }
    }
}
