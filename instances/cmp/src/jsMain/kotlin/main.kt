@file:Suppress("Filename")

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import di.RootModule
import examplepackage.features.root.ui.modal.composable.component.RootDialogContentComposable
import examplepackage.features.root.ui.screen.composable.screen.RootScreenComposable
import examplepackage.features.theme.ui.theme.ApplicationTheme
import org.jetbrains.skiko.wasm.onWasmReady
import ru.astrainteractive.klibs.mikro.platform.DefaultJSPlatformConfiguration

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val rootModule = RootModule()
    rootModule.coreModule.platformConfigurationInternal = DefaultJSPlatformConfiguration()
    val lifecycle = LifecycleRegistry()
    val componentContext = DefaultComponentContext(lifecycle)
    val rootComponent = rootModule.createRootComponent(componentContext)
    val rootBottomSheetComponent = rootComponent.rootBottomSheetComponent

    onWasmReady {
        ComposeViewport("root") {
            ApplicationTheme(rootModule.themeSwitcherModule.themeSwitcherComponent) {
                RootDialogContentComposable(rootBottomSheetComponent)
                RootScreenComposable(
                    rootComponent = rootComponent,
                    modifier = Modifier
                )
            }
        }
    }
}
