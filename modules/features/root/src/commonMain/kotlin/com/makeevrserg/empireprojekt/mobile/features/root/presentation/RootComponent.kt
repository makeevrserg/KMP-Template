package com.makeevrserg.empireprojekt.mobile.features.root.presentation

import com.makeevrserg.empireprojekt.mobile.features.modal.presentation.RootBottomSheetComponent
import com.makeevrserg.empireprojekt.mobile.features.screen.presentation.RootScreenComponent

interface RootComponent {
    val rootScreenComponent: RootScreenComponent
    val rootBottomSheetComponent: RootBottomSheetComponent
}
