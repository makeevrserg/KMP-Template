package examplepackage.features.screen.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import examplepackage.features.root.component.RootComponent
import examplepackage.features.screen.component.RootScreenComponent
import examplepackage.features.splash.composable.screen.SplashScreenComponent

@Composable
private fun RootSplashScreenContent(
    screen: RootScreenComponent.Child.Splash,
    rootComponent: RootComponent
) {
    SplashScreenComponent(
        splashComponent = screen.splashComponent,
        onIconClick = { rootComponent.rootBottomSheetComponent.showInfoSheet() }
    )
}

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
            is RootScreenComponent.Child.Splash -> RootSplashScreenContent(screen, rootComponent)
        }
    }
}
