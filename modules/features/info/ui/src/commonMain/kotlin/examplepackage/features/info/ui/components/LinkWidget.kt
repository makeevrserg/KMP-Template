package examplepackage.features.info.ui.components

import androidx.compose.runtime.Composable
import examplepackage.core.ui.components.rowitem.RowSettingChevronItem
import examplepackage.features.info.linkbrowser.LinkBrowser
import examplepackage.features.info.ui.model.LinkModel

@Composable
internal fun LinkWidget(
    linkBrowser: LinkBrowser = rememberLinkBrowser(),
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
