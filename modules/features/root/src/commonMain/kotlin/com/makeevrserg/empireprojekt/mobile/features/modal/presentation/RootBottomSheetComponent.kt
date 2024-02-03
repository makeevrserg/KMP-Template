package com.makeevrserg.empireprojekt.mobile.features.modal.presentation

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.value.Value

interface RootBottomSheetComponent {

    val childSlot: Value<ChildSlot<*, Child>>

    fun dismiss()

    fun showInfoSheet()

    sealed interface Child {
        data object Info : Child
    }
}
