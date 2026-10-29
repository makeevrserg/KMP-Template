package examplepackage.features.root.di

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.root.component.RootComponent
import examplepackage.features.splash.di.SplashModule
import examplepackage.features.splash.di.buildSplashModule
import examplepackage.features.theming.di.ThemeSwitcherModule
import examplepackage.features.theming.di.buildThemeSwitcherModule
import examplepackage.services.core.di.CoreModule
import examplepackage.services.core.di.buildCoreModule

interface RootModule {

    val coreModule: CoreModule
    val themeSwitcherModule: ThemeSwitcherModule
    val splashModule: SplashModule

    fun createRootComponent(componentContext: ComponentContext): RootComponent

    class Default : RootModule {
        override val coreModule: CoreModule = buildCoreModule()

        override val themeSwitcherModule: ThemeSwitcherModule by lazy {
            buildThemeSwitcherModule(coreModule.settings)
        }
        override val splashModule: SplashModule by lazy {
            buildSplashModule(
                mainScope = coreModule.mainScope,
                dispatchers = coreModule.dispatchers
            )
        }

        override fun createRootComponent(componentContext: ComponentContext): RootComponent {
            return buildRootComponent(componentContext, splashModule)
        }
    }
}
