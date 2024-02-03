package com.makeevrserg.applicationtemplate.mobile.features.screen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.applicationtemplate.mobile.features.root.presentation.RootComponent
import com.makeevrserg.applicationtemplate.mobile.features.screen.presentation.RootScreenComponent
import com.makeevrserg.applicationtemplate.mobile.features.splash.ui.SplashScreenComponent

@Composable
fun RootScreenContent(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier
) {
    val childStack by rootComponent.rootScreenComponent.childStack.subscribeAsState()
    Children(
        stack = childStack,
        modifier = modifier.fillMaxSize(),
        animation = stackAnimation(slide())
    ) { configuration ->

        when (val screen = configuration.instance) {
            is RootScreenComponent.Child.Splash -> SplashScreenComponent(
                rootComponent = rootComponent,
                splashComponent = screen.splashComponent,
                onIconClicked = {
                    rootComponent.rootBottomSheetComponent.showInfoSheet()
                }
            )
        }
    }
}
