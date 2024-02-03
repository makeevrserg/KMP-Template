package com.makeevrserg.applicationtemplate.mobile.features.root.presentation

import com.makeevrserg.applicationtemplate.mobile.features.modal.presentation.RootBottomSheetComponent
import com.makeevrserg.applicationtemplate.mobile.features.screen.presentation.RootScreenComponent

interface RootComponent {
    val rootScreenComponent: RootScreenComponent
    val rootBottomSheetComponent: RootBottomSheetComponent
}
