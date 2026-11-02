package examplepackage.features.root.ui.screen.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import examplepackage.features.root.impl.component.RootComponent
import examplepackage.features.root.impl.screen.component.RootScreenComponent
import examplepackage.features.splash.ui.composable.screen.SplashScreenComposable

@Composable
private fun RootSplashContentComposable(
    screen: RootScreenComponent.Child.Splash,
    rootComponent: RootComponent
) {
    SplashScreenComposable(
        splashComponent = screen.splashComponent,
        onIconClick = { rootComponent.rootBottomSheetComponent.showInfoSheet() }
    )
}

@Composable
fun RootScreenComposable(
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
            is RootScreenComponent.Child.Splash -> RootSplashContentComposable(screen, rootComponent)
        }
    }
}
