package examplepackage.features.modal.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import com.arkivanov.decompose.router.slot.childSlot as createChildSlot

internal class DefaultRootBottomSheetComponent(
    componentContext: ComponentContext,
) : RootBottomSheetComponent, ComponentContext by componentContext {
    private val slotNavigation = SlotNavigation<BottomSheetConfiguration>()

    override val childSlot: Value<ChildSlot<*, RootBottomSheetComponent.BottomSheetChild>> = createChildSlot(
        source = slotNavigation,
        serializer = BottomSheetConfiguration.serializer(),
        handleBackButton = true,
        childFactory = { configuration, context ->
            when (configuration) {
                BottomSheetConfiguration.Info -> {
                    RootBottomSheetComponent.BottomSheetChild.Info
                }
            }
        }
    )

    override fun dismiss() {
        slotNavigation.dismiss()
    }

    override fun showInfoSheet() {
        slotNavigation.activate(BottomSheetConfiguration.Info)
    }

    @Serializable
    sealed interface BottomSheetConfiguration {
        @Serializable
        data object Info : BottomSheetConfiguration
    }
}
