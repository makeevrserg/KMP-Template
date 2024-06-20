package com.makeevrserg.applicationtemplate.mobile.features.modal.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.makeevrserg.applicationtemplate.mobile.core.ui.components.bottomsheet.SlotModalBottomSheet
import com.makeevrserg.applicationtemplate.mobile.features.info.ui.InfoScreen
import com.makeevrserg.applicationtemplate.mobile.features.modal.presentation.RootBottomSheetComponent

@Composable
fun RootBottomSheetContent(
    rootBottomSheetComponent: RootBottomSheetComponent,
) {
    val slot by rootBottomSheetComponent.childSlot.subscribeAsState()
    SlotModalBottomSheet(
        childSlot = slot,
        onDismiss = rootBottomSheetComponent::dismiss,
        content = { child ->
            when (child) {
                is RootBottomSheetComponent.Child.Info -> {
                    InfoScreen()
                }
            }
        }
    )
}
