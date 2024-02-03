package com.makeevrserg.empireprojekt.mobile.features.screen.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.makeevrserg.empireprojekt.mobile.features.splash.presentation.SplashComponent

interface RootScreenComponent : BackHandlerOwner {
    val childStack: Value<ChildStack<*, Child>>

    fun push(configuration: Configuration)
    fun replaceCurrent(configuration: Configuration)
    fun replaceAll(configuration: Configuration)
    fun pop()

    sealed interface Child {
        class Splash(val splashComponent: SplashComponent) : Child
    }

    sealed interface Configuration : Parcelable {
        @Parcelize
        data object Splash : Configuration
    }
}
