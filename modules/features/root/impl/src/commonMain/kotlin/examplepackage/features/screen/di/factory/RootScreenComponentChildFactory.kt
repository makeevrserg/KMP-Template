package examplepackage.features.screen.di.factory

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.root.di.RootModule
import examplepackage.features.screen.presentation.RootScreenComponent

internal class RootScreenComponentChildFactory(
    private val config: RootScreenComponent.Configuration,
    private val componentContext: ComponentContext,
    private val rootModule: RootModule,
) {
    fun create(): RootScreenComponent.Child {
        return when (config) {
            is RootScreenComponent.Configuration.Splash -> RootScreenComponent.Child.Splash(
                splashComponent = rootModule.splashModule.createSplashComponent(componentContext)
            )
        }
    }
}
