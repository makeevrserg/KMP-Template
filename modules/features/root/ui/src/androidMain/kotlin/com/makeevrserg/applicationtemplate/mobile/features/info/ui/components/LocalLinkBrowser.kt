package com.makeevrserg.applicationtemplate.mobile.features.info.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.makeevrserg.applicationtemplate.mobile.features.info.linkbrowser.AndroidLinkBrowser
import com.makeevrserg.applicationtemplate.mobile.features.info.linkbrowser.LinkBrowser

@Composable
actual fun LocalLinkBrowser(): LinkBrowser {
    return AndroidLinkBrowser(LocalContext.current)
}
