package examplepackage.features.modal.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

internal class DefaultRootBottomSheetComponent(
    componentContext: ComponentContext,
) : RootBottomSheetComponent, ComponentContext by componentContext {
    private val slotNavigation = SlotNavigation<Configuration>()

    override val childSlot: Value<ChildSlot<*, RootBottomSheetComponent.Child>> = childSlot(
        source = slotNavigation,
        serializer = Configuration.serializer(),
        handleBackButton = true,
        childFactory = { configuration, context ->
            when (configuration) {
                Configuration.Info -> {
                    RootBottomSheetComponent.Child.Info
                }
            }
        }
    )

    override fun dismiss() {
        slotNavigation.dismiss()
    }

    override fun showInfoSheet() {
        slotNavigation.activate(Configuration.Info)
    }

    @Serializable
    sealed interface Configuration {
        @Serializable
        data object Info : Configuration
    }
}
