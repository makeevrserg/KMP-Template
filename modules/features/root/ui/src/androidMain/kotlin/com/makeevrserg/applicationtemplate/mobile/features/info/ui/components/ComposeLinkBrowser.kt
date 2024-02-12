package com.makeevrserg.applicationtemplate.mobile.features.info.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.makeevrserg.applicationtemplate.mobile.features.info.linkbrowser.AndroidLinkBrowser
import com.makeevrserg.applicationtemplate.mobile.features.info.linkbrowser.LinkBrowser

@Composable
internal actual fun rememberLinkBrowser(): LinkBrowser {
    val context = LocalContext.current
    return remember { AndroidLinkBrowser(context) }
}
