package examplepackage.features.info.composable.component

import androidx.compose.runtime.Composable
import examplepackage.core.ui.composable.component.RowSettingChevronItem
import examplepackage.features.info.link.api.LinkBrowser
import examplepackage.features.info.model.Link

@Composable
internal fun LinkWidget(
    linkModel: Link,
    linkBrowser: LinkBrowser = rememberLinkBrowser()
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
