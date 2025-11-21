package examplepackage.core.ui.components.bottomsheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.arkivanov.decompose.router.slot.ChildSlot
import examplepackage.core.ui.components.bottomsheet.util.zero
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop

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