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
import com.makeevrserg.applicationtemplate.modules.services.core.resources.ic_esmp
import di.RootModule
import examplepackage.features.root.ui.modal.composable.component.RootDialogContentComposable
import examplepackage.features.root.ui.screen.composable.screen.RootScreenComposable
import examplepackage.features.theme.ui.composable.layout.ApplicationTheme
import ru.astrainteractive.klibs.mikro.platform.DefaultJVMPlatformConfiguration

fun main() {
    val rootModule = RootModule()
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
            RootDialogContentComposable(rootBottomSheetComponent)
            RootScreenComposable(
                rootComponent = rootComponent,
                modifier = Modifier
            )
        }
    }
}
