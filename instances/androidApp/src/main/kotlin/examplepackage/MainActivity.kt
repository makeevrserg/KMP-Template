package examplepackage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.arkivanov.decompose.defaultComponentContext
import examplepackage.application.App.Companion.asMyApplication
import examplepackage.features.modal.ui.RootBottomSheetContent
import examplepackage.features.root.di.RootModule
import examplepackage.features.screen.ui.RootScreenContent
import examplepackage.features.theme.ui.ApplicationTheme

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private val rootModule: RootModule
        get() = application.asMyApplication().rootModule

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val componentContext = defaultComponentContext()
        val rootComponent = rootModule.createRootComponent(componentContext)
        val rootBottomSheetComponent = rootComponent.rootBottomSheetComponent
        setContent {
            ApplicationTheme(rootModule.themeSwitcherModule.themeSwitcherComponent) {
                RootBottomSheetContent(rootBottomSheetComponent)
                RootScreenContent(
                    rootComponent = rootComponent,
                    modifier = Modifier
                )
            }
        }
        splashScreen.setKeepOnScreenCondition { false }
    }
}
