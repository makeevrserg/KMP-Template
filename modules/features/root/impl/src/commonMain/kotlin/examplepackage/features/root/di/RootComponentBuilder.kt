package examplepackage.features.root.di

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import examplepackage.features.modal.component.DefaultRootBottomSheetComponent
import examplepackage.features.root.component.DefaultRootComponent
import examplepackage.features.root.component.RootComponent
import examplepackage.features.screen.component.DefaultRootScreenComponent
import examplepackage.features.screen.component.RootScreenComponent
import examplepackage.features.splash.di.SplashModule

private fun createRootScreenComponentChild(
    splashModule: SplashModule,
    config: RootScreenComponent.Configuration,
    componentContext: ComponentContext
): RootScreenComponent.Child {
    return when (config) {
        is RootScreenComponent.Configuration.Splash -> RootScreenComponent.Child.Splash(
            splashComponent = splashModule.createSplashComponent(componentContext)
        )
    }
}

internal fun buildRootComponent(
    componentContext: ComponentContext,
    splashModule: SplashModule
): RootComponent {
    val rootBottomSheetComponent = DefaultRootBottomSheetComponent(
        componentContext = componentContext.childContext("RootBottomSheetComponent")
    )
    val rootScreenComponent = DefaultRootScreenComponent(
        componentContext = componentContext.childContext("RootScreenComponent"),
        childFactory = { config, context ->
            createRootScreenComponentChild(
                splashModule = splashModule,
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
