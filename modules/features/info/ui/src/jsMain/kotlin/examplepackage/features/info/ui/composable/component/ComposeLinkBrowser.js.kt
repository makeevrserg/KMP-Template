package examplepackage.features.info.ui.composable.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import examplepackage.features.info.ui.link.api.LinkBrowser
import examplepackage.features.info.ui.link.component.JsLinkBrowser

@Composable
internal actual fun rememberLinkBrowser(): LinkBrowser {
    return remember { JsLinkBrowser() }
}
