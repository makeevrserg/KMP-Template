@file:Suppress("Filename")

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import examplepackage.features.modal.ui.RootDialogContent
import examplepackage.features.root.di.RootModule
import examplepackage.features.screen.ui.RootScreenContent
import examplepackage.features.theme.ui.ApplicationTheme
import org.jetbrains.skiko.wasm.onWasmReady
import ru.astrainteractive.klibs.mikro.platform.DefaultJSPlatformConfiguration

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val rootModule = RootModule.Default()
    rootModule.coreModule.platformConfigurationInternal = DefaultJSPlatformConfiguration()
    val lifecycle = LifecycleRegistry()
    val componentContext = DefaultComponentContext(lifecycle)
    val rootComponent = rootModule.createRootComponent(componentContext)
    val rootBottomSheetComponent = rootComponent.rootBottomSheetComponent

    onWasmReady {
        ComposeViewport("root") {
            ApplicationTheme(rootModule.themeSwitcherModule.themeSwitcherComponent) {
                RootDialogContent(rootBottomSheetComponent)
                RootScreenContent(
                    rootComponent = rootComponent,
                    modifier = Modifier
                )
            }
        }
    }
}
