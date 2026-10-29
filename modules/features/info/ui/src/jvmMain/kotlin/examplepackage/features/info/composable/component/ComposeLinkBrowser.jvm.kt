package examplepackage.features.info.composable.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import examplepackage.features.info.link.api.LinkBrowser
import examplepackage.features.info.link.component.JvmLinkBrowser

@Composable
internal actual fun rememberLinkBrowser(): LinkBrowser {
    return remember { JvmLinkBrowser() }
}
