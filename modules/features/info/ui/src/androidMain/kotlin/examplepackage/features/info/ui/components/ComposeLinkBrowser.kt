package examplepackage.features.info.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import examplepackage.features.info.linkbrowser.AndroidLinkBrowser
import examplepackage.features.info.linkbrowser.LinkBrowser

@Composable
internal actual fun rememberLinkBrowser(): LinkBrowser {
    val context = LocalContext.current
    return remember { AndroidLinkBrowser(context) }
}
