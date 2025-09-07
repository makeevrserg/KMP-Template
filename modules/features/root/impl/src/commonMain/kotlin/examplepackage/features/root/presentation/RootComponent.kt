package examplepackage.features.root.presentation

import examplepackage.features.modal.presentation.RootBottomSheetComponent
import examplepackage.features.screen.presentation.RootScreenComponent

interface RootComponent {
    val rootScreenComponent: RootScreenComponent
    val rootBottomSheetComponent: RootBottomSheetComponent
}
