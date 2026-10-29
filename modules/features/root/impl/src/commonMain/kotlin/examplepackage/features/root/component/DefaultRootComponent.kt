package examplepackage.features.root.component

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.modal.component.RootBottomSheetComponent
import examplepackage.features.screen.component.RootScreenComponent

internal class DefaultRootComponent(
    componentContext: ComponentContext,
    override val rootBottomSheetComponent: RootBottomSheetComponent,
    override val rootScreenComponent: RootScreenComponent
) : RootComponent, ComponentContext by componentContext
