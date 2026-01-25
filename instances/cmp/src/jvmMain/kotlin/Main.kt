import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR
import examplepackage.features.modal.ui.RootDialogContent
import examplepackage.features.root.di.RootModule
import examplepackage.features.screen.ui.RootScreenContent
import examplepackage.features.theme.ui.ApplicationTheme
import ru.astrainteractive.klibs.mikro.platform.DefaultJVMPlatformConfiguration

fun main() {
    val rootModule = RootModule.Default()
    rootModule.coreModule.platformConfigurationInternal = DefaultJVMPlatformConfiguration()
    val lifecycle = LifecycleRegistry()
    val componentContext = DefaultComponentContext(lifecycle)
    val rootComponent = runOnUiThread { rootModule.createRootComponent(componentContext) }
    val rootBottomSheetComponent = rootComponent.rootBottomSheetComponent

    val windowState = WindowState(
        placement = WindowPlacement.Floating,
        size = DpSize(600.dp, 800.dp)
    )

    singleWindowApplication(
        state = windowState,
        title = "AstraLearner",
        icon = BitmapPainter(
            useResource(
                CoreR.images.ic_esmp.filePath,
                ::loadImageBitmap
            )
        ),
    ) {
        LifecycleController(lifecycle, windowState)
        ApplicationTheme(rootModule.themeSwitcherModule.themeSwitcherComponent) {
            RootDialogContent(rootBottomSheetComponent)
            RootScreenContent(
                rootComponent = rootComponent,
                modifier = Modifier
            )
        }
    }
}
