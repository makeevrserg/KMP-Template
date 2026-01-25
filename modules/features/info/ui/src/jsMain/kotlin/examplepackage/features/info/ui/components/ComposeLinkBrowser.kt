package examplepackage.features.info.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import examplepackage.features.info.linkbrowser.JsLinkBrowser
import examplepackage.features.info.linkbrowser.LinkBrowser

@Composable
internal actual fun rememberLinkBrowser(): LinkBrowser {
    return remember { JsLinkBrowser() }
}
