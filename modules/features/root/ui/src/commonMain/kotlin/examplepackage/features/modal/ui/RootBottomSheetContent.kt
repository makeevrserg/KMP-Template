package examplepackage.features.modal.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import examplepackage.core.ui.components.bottomsheet.SlotModalBottomSheet
import examplepackage.features.info.ui.InfoScreen
import examplepackage.features.modal.presentation.RootBottomSheetComponent

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
