package com.makeevrserg.applicationtemplate.mobile.features.screen.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.makeevrserg.applicationtemplate.mobile.features.splash.presentation.SplashComponent
import kotlinx.serialization.Serializable

interface RootScreenComponent : BackHandlerOwner {
    val childStack: Value<ChildStack<*, Child>>

    fun push(configuration: Configuration)
    fun replaceCurrent(configuration: Configuration)
    fun replaceAll(configuration: Configuration)
    fun pop()

    sealed interface Child {
        class Splash(val splashComponent: SplashComponent) : Child
    }

    @Serializable
    sealed interface Configuration {
        @Serializable
        data object Splash : Configuration
    }
}
