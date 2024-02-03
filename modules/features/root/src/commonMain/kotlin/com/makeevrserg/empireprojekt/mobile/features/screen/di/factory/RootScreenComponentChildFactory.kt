package com.makeevrserg.empireprojekt.mobile.features.screen.di.factory

import com.arkivanov.decompose.ComponentContext
import com.makeevrserg.empireprojekt.mobile.features.logic.splash.DefaultSplashComponent
import com.makeevrserg.empireprojekt.mobile.features.root.di.RootModule
import com.makeevrserg.empireprojekt.mobile.features.screen.presentation.RootScreenComponent
import ru.astrainteractive.klibs.kdi.Factory

internal class RootScreenComponentChildFactory(
    private val config: RootScreenComponent.Configuration,
    private val context: ComponentContext,
    private val rootModule: RootModule,
) : Factory<RootScreenComponent.Child> {
    override fun create(): RootScreenComponent.Child {
        return when (config) {
            is RootScreenComponent.Configuration.Splash -> RootScreenComponent.Child.Splash(
                splashComponent = DefaultSplashComponent(
                    context = context,
                    module = rootModule.splashModule
                )
            )
        }
    }
}
