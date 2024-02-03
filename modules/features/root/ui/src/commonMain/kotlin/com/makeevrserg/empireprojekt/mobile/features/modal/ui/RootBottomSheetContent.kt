package com.makeevrserg.empireprojekt.mobile.features.modal.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.empireprojekt.mobile.core.ui.rememberDeclarativeModalBottomSheetState
import com.makeevrserg.empireprojekt.mobile.core.ui.theme.AppTheme
import com.makeevrserg.empireprojekt.mobile.features.info.ui.InfoScreen
import com.makeevrserg.empireprojekt.mobile.features.modal.presentation.RootBottomSheetComponent

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RootBottomSheetContent(
    rootBottomSheetComponent: RootBottomSheetComponent,
    content: @Composable () -> Unit
) {
    val slot by rootBottomSheetComponent.childSlot.subscribeAsState()
    val bottomSheetState = rememberDeclarativeModalBottomSheetState(
        child = slot.child,
        onDismiss = rootBottomSheetComponent::dismiss
    ) { child ->
        when (val instance = child.instance) {
            is RootBottomSheetComponent.Child.Info -> {
                InfoScreen()
            }
        }
    }
    ModalBottomSheetLayout(
        sheetState = bottomSheetState.sheetState,
        sheetContent = bottomSheetState.sheetContent.value,
        sheetShape = RoundedCornerShape(AppTheme.dimens.S),
        sheetBackgroundColor = MaterialTheme.colors.primary,
        content = content
    )
}
