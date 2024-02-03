package com.makeevrserg.empireprojekt.mobile.features.splash.di

import com.arkivanov.decompose.ComponentContext
import com.makeevrserg.empireprojekt.mobile.features.splash.presentation.DefaultSplashComponent
import com.makeevrserg.empireprojekt.mobile.features.splash.presentation.SplashComponent
import com.makeevrserg.empireprojekt.mobile.services.core.di.CoreModule

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
}
