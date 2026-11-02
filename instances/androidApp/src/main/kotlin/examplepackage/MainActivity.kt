package examplepackage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.arkivanov.decompose.defaultComponentContext
import examplepackage.App.Companion.asMyApplication
import examplepackage.di.RootModule
import examplepackage.features.root.ui.modal.composable.component.RootDialogContentComposable
import examplepackage.features.root.ui.screen.composable.screen.RootScreenComposable
import examplepackage.features.theme.ui.composable.layout.ApplicationTheme

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
                RootDialogContentComposable(rootBottomSheetComponent)
                RootScreenComposable(
                    rootComponent = rootComponent,
                    modifier = Modifier
                )
            }
        }
        splashScreen.setKeepOnScreenCondition { false }
    }
}
