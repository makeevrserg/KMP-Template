package com.makeevrserg.applicationtemplate.mobile.features.info.ui.components

import androidx.compose.runtime.Composable
import com.makeevrserg.applicationtemplate.mobile.core.ui.components.RowSettingChevronItem
import com.makeevrserg.applicationtemplate.mobile.features.info.linkbrowser.LinkBrowser
import com.makeevrserg.applicationtemplate.mobile.features.info.ui.model.LinkModel

@Composable
fun LinkWidget(
    linkBrowser: LinkBrowser = LocalLinkBrowser(),
    linkModel: LinkModel
) {
    RowSettingChevronItem(
        icon = linkModel.res,
        text = linkModel.title,
        tint = linkModel.tint.invoke(),
        onClick = {
            linkBrowser.openInBrowser(linkModel.url)
        }
    )
}
