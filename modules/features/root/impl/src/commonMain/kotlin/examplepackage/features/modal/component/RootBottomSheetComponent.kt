package examplepackage.features.modal.component

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.value.Value

interface RootBottomSheetComponent {

    val childSlot: Value<ChildSlot<*, BottomSheetChild>>

    fun dismiss()

    fun showInfoSheet()

    sealed interface BottomSheetChild {
        data object Info : BottomSheetChild
    }
}
