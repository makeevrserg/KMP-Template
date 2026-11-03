package examplepackage.features.root.impl.di

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import examplepackage.features.root.impl.component.DefaultRootComponent
import examplepackage.features.root.impl.component.RootComponent
import examplepackage.features.root.impl.modal.component.DefaultRootBottomSheetComponent
import examplepackage.features.root.impl.screen.component.DefaultRootScreenComponent
import examplepackage.features.root.impl.screen.component.RootScreenComponent
import examplepackage.features.splash.api.component.SplashComponent

private fun createRootScreenComponentChild(
    splashFactory: SplashComponent.Factory,
    config: RootScreenComponent.Configuration,
    componentContext: ComponentContext
): RootScreenComponent.Child {
    return when (config) {
        is RootScreenComponent.Configuration.Splash -> RootScreenComponent.Child.Splash(
            splashComponent = splashFactory.invoke(componentContext)
        )
    }
}

internal fun buildRootComponent(
    componentContext: ComponentContext,
    splashFactory: SplashComponent.Factory
): RootComponent {
    val rootBottomSheetComponent = DefaultRootBottomSheetComponent(
        componentContext = componentContext.childContext("RootBottomSheetComponent")
    )
    val rootScreenComponent = DefaultRootScreenComponent(
        componentContext = componentContext.childContext("RootScreenComponent"),
        childFactory = { config, context ->
            createRootScreenComponentChild(
                splashFactory = splashFactory,
                config = config,
                componentContext = context
            )
        }
    )
    return DefaultRootComponent(
        componentContext = componentContext,
        rootBottomSheetComponent = rootBottomSheetComponent,
        rootScreenComponent = rootScreenComponent
    )
}
