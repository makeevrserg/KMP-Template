package examplepackage.core.ui.components.bottomsheet

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.arkivanov.decompose.router.slot.ChildSlot

@Composable
fun <T : Any, K : Any> SlotModalDialog(
    childSlot: ChildSlot<T, K>,
    properties: DialogProperties = DialogProperties(),
    onDismiss: () -> Unit,
    content: @Composable (K) -> Unit
) {
    val child = childSlot.child?.instance
    child?.let {
        Dialog(
            onDismissRequest = onDismiss,
            properties = properties,
            content = { content.invoke(child) }
        )
    }
}
