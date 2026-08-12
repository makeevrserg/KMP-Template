package examplepackage.features.splash.di

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.splash.data.SplashComponentRepository
import examplepackage.features.splash.data.SplashComponentRepositoryImpl
import examplepackage.features.splash.presentation.DefaultSplashComponent
import examplepackage.features.splash.presentation.SplashComponent
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
        private val repository: SplashComponentRepository = SplashComponentRepositoryImpl()

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
