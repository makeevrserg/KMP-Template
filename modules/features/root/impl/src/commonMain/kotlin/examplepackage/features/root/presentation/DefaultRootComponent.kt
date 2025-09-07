package examplepackage.features.root.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import examplepackage.features.modal.presentation.DefaultRootBottomSheetComponent
import examplepackage.features.modal.presentation.RootBottomSheetComponent
import examplepackage.features.root.di.RootModule
import examplepackage.features.screen.presentation.DefaultRootScreenComponent
import examplepackage.features.screen.presentation.RootScreenComponent

internal class DefaultRootComponent(
    componentContext: ComponentContext,
    rootModule: RootModule
) : RootComponent, ComponentContext by componentContext {
    override val rootBottomSheetComponent: RootBottomSheetComponent = DefaultRootBottomSheetComponent(
        componentContext = childContext("RootBottomSheetComponent"),
    )
    override val rootScreenComponent: RootScreenComponent = DefaultRootScreenComponent(
        componentContext = childContext("RootScreenComponent"),
        rootModule = rootModule,
    )
}
