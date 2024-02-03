package com.makeevrserg.empireprojekt.mobile.features.root.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.makeevrserg.empireprojekt.mobile.features.modal.presentation.DefaultRootBottomSheetComponent
import com.makeevrserg.empireprojekt.mobile.features.modal.presentation.RootBottomSheetComponent
import com.makeevrserg.empireprojekt.mobile.features.root.di.RootModule
import com.makeevrserg.empireprojekt.mobile.features.screen.presentation.DefaultRootScreenComponent
import com.makeevrserg.empireprojekt.mobile.features.screen.presentation.RootScreenComponent

class DefaultRootComponent(
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
