package examplepackage.features.info.composable.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import examplepackage.features.info.link.api.LinkBrowser
import examplepackage.features.info.link.component.AndroidLinkBrowser

@Composable
internal actual fun rememberLinkBrowser(): LinkBrowser {
    val context = LocalContext.current
    return remember { AndroidLinkBrowser(context) }
}
