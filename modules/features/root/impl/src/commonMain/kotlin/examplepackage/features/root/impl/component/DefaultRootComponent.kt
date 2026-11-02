package examplepackage.features.root.impl.component

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.root.impl.modal.component.RootBottomSheetComponent
import examplepackage.features.root.impl.screen.component.RootScreenComponent

internal class DefaultRootComponent(
    componentContext: ComponentContext,
    override val rootBottomSheetComponent: RootBottomSheetComponent,
    override val rootScreenComponent: RootScreenComponent
) : RootComponent, ComponentContext by componentContext
