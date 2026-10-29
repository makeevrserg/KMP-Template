package examplepackage.features.root.component

import examplepackage.features.modal.component.RootBottomSheetComponent
import examplepackage.features.screen.component.RootScreenComponent

interface RootComponent {
    val rootScreenComponent: RootScreenComponent
    val rootBottomSheetComponent: RootBottomSheetComponent
}
