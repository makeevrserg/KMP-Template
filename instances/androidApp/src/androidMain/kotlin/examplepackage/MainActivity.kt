package examplepackage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.arkivanov.decompose.defaultComponentContext
import examplepackage.application.App.Companion.asMyApplication
import examplepackage.features.modal.ui.RootDialogContent
import examplepackage.features.root.di.RootModule
import examplepackage.features.screen.ui.RootScreenContent
import examplepackage.features.theme.ui.ApplicationTheme

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
                RootDialogContent(rootBottomSheetComponent)
                RootScreenContent(
                    rootComponent = rootComponent,
                    modifier = Modifier
                )
            }
        }
        splashScreen.setKeepOnScreenCondition { false }
    }
}
