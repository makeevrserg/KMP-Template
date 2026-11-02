package di

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.root.impl.component.RootComponent
import examplepackage.features.root.impl.di.RootFeatureModule
import examplepackage.features.splash.impl.di.buildSplashModule
import examplepackage.features.theme.impl.di.buildThemeSwitcherModule
import examplepackage.services.core.di.buildCoreModule

internal class RootModule {
    val coreModule = buildCoreModule()
    val themeSwitcherModule by lazy { buildThemeSwitcherModule(coreModule.settings) }
    val splashModule by lazy {
        buildSplashModule(
            mainScope = coreModule.mainScope,
            dispatchers = coreModule.dispatchers
        )
    }
    private val rootFeatureModule by lazy { RootFeatureModule(splashModule) }

    fun createRootComponent(componentContext: ComponentContext): RootComponent {
        return rootFeatureModule.createRootComponent(componentContext)
    }
}
