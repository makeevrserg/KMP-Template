package examplepackage.features.root.impl.component

import examplepackage.features.root.impl.modal.component.RootBottomSheetComponent
import examplepackage.features.root.impl.screen.component.RootScreenComponent

interface RootComponent {
    val rootScreenComponent: RootScreenComponent
    val rootBottomSheetComponent: RootBottomSheetComponent
}
