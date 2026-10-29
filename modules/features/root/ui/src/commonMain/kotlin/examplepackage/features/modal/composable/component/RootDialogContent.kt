package examplepackage.features.modal.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import examplepackage.core.ui.composable.component.SlotModalDialog
import examplepackage.features.info.composable.screen.InfoScreen
import examplepackage.features.modal.component.RootBottomSheetComponent

@Composable
private fun DialogBox(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.primaryVariant)
            .padding(PaddingValues(8.dp)),
        contentAlignment = Alignment.Center,
        content = {
            content.invoke(this)
        }
    )
}

@Composable
fun RootDialogContent(
    rootBottomSheetComponent: RootBottomSheetComponent,
) {
    val slot by rootBottomSheetComponent.childSlot.subscribeAsState()
    SlotModalDialog(
        childSlot = slot,
        onDismiss = rootBottomSheetComponent::dismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = true
        ),
        content = { child ->
            when (child) {
                is RootBottomSheetComponent.BottomSheetChild.Info -> DialogBox { InfoScreen() }
            }
        }
    )
}
