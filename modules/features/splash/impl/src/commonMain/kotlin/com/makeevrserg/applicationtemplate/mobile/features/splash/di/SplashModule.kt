package com.makeevrserg.applicationtemplate.mobile.features.splash.di

import com.arkivanov.decompose.ComponentContext
import com.makeevrserg.applicationtemplate.mobile.features.splash.data.SplashComponentRepository
import com.makeevrserg.applicationtemplate.mobile.features.splash.presentation.DefaultSplashComponent
import com.makeevrserg.applicationtemplate.mobile.features.splash.presentation.SplashComponent
import com.makeevrserg.applicationtemplate.mobile.services.core.di.CoreModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

interface SplashModule {
    fun createSplashComponent(componentContext: ComponentContext): SplashComponent

    class Default(
        private val coreModule: CoreModule
    ) : SplashModule {
        override fun createSplashComponent(componentContext: ComponentContext): SplashComponent {
            val dependencies = SplashComponentDependencies.Default(
                mainScope = coreModule.mainScope.value,
                dispatchers = coreModule.dispatchers.value
            )
            return DefaultSplashComponent(
                componentContext = componentContext,
                dependencies = dependencies
            )
        }
    }

    class Preview : SplashModule {
        private class FakeSplashComponentDependencies(
            override val mainScope: CoroutineScope = MainScope(),
            override val dispatchers: KotlinDispatchers = DefaultKotlinDispatchers,
            override val repository: SplashComponentRepository = object : SplashComponentRepository {
                override fun isInitialLaunch(): Boolean = true
            }
        ) : SplashComponentDependencies

        override fun createSplashComponent(componentContext: ComponentContext): SplashComponent {
            return DefaultSplashComponent(
                componentContext = componentContext,
                dependencies = FakeSplashComponentDependencies()
            )
        }
    }
}
