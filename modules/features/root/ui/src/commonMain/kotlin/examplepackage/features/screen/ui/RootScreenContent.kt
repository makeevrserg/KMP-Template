package examplepackage.features.screen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import examplepackage.features.root.presentation.RootComponent
import examplepackage.features.screen.presentation.RootScreenComponent
import examplepackage.features.splash.ui.SplashScreenComponent

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
                splashComponent = screen.splashComponent,
                onIconClicked = {
                    rootComponent.rootBottomSheetComponent.showInfoSheet()
                }
            )
        }
    }
}
