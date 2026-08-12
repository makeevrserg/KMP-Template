package examplepackage.features.screen.di.factory

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.screen.presentation.RootScreenComponent
import examplepackage.features.splash.di.SplashModule

internal class RootScreenComponentChildFactory(
    private val config: RootScreenComponent.Configuration,
    private val componentContext: ComponentContext,
    private val splashModule: SplashModule,
) {
    fun create(): RootScreenComponent.Child {
        return when (config) {
            is RootScreenComponent.Configuration.Splash -> RootScreenComponent.Child.Splash(
                splashComponent = splashModule.createSplashComponent(componentContext)
            )
        }
    }
}
