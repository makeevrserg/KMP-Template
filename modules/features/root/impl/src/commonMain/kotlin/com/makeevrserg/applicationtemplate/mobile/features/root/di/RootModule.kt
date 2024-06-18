package com.makeevrserg.applicationtemplate.mobile.features.root.di

import com.arkivanov.decompose.ComponentContext
import com.makeevrserg.applicationtemplate.mobile.features.root.presentation.DefaultRootComponent
import com.makeevrserg.applicationtemplate.mobile.features.root.presentation.RootComponent
import com.makeevrserg.applicationtemplate.mobile.features.splash.di.SplashModule
import com.makeevrserg.applicationtemplate.mobile.features.theme.di.ThemeSwitcherModule
import com.makeevrserg.applicationtemplate.mobile.services.core.di.CoreModule
import ru.astrainteractive.klibs.kdi.Single
import ru.astrainteractive.klibs.kdi.getValue

interface RootModule {

    val coreModule: CoreModule
    val themeSwitcherModule: ThemeSwitcherModule
    val splashModule: SplashModule

    fun createRootComponent(componentContext: ComponentContext): RootComponent

    class Default : RootModule {
        override val coreModule: CoreModule by Single {
            CoreModule.Default()
        }

        override val themeSwitcherModule: ThemeSwitcherModule by lazy {
            ThemeSwitcherModule.Default(coreModule.settings.value)
        }
        override val splashModule: SplashModule by lazy {
            SplashModule.Default(coreModule = coreModule)
        }

        override fun createRootComponent(componentContext: ComponentContext): RootComponent {
            return DefaultRootComponent(
                componentContext = componentContext,
                rootModule = this
            )
        }
    }
}
