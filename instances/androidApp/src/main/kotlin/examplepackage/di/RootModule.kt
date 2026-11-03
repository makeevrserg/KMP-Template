package examplepackage.di

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.root.impl.component.RootComponent
import examplepackage.features.root.impl.di.RootFeatureModule
import examplepackage.features.splash.impl.di.SplashModule
import examplepackage.features.theme.impl.di.ThemeSwitcherModule
import examplepackage.services.core.di.CoreModule

internal class RootModule {
    val coreModule: CoreModule = CoreModule.Default()
    val themeSwitcherModule: ThemeSwitcherModule by lazy { ThemeSwitcherModule.Default(coreModule.settings) }
    val splashModule: SplashModule by lazy {
        SplashModule.Default(
            mainScope = coreModule.mainScope,
            dispatchers = coreModule.dispatchers
        )
    }
    private val rootFeatureModule by lazy { RootFeatureModule(splashModule) }

    fun createRootComponent(componentContext: ComponentContext): RootComponent {
        return rootFeatureModule.createRootComponent(componentContext)
    }
}
