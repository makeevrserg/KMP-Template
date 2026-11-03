package examplepackage.features.root.impl.di

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.root.impl.component.RootComponent
import examplepackage.features.splash.api.component.SplashComponent

class RootFeatureModule(private val splashFactory: SplashComponent.Factory) {
    fun createRootComponent(componentContext: ComponentContext): RootComponent {
        return buildRootComponent(componentContext, splashFactory)
    }
}
