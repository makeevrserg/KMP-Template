package examplepackage.features.info.ui.composable.component

import androidx.compose.runtime.Composable
import examplepackage.core.ui.common.composable.component.RowSettingChevronItemComposable
import examplepackage.features.info.ui.link.api.LinkBrowser
import examplepackage.features.info.ui.model.Link

@Composable
internal fun LinkWidgetComposable(
    linkModel: Link,
    linkBrowser: LinkBrowser = rememberLinkBrowser()
) {
    RowSettingChevronItemComposable(
        icon = linkModel.res,
        text = linkModel.title,
        tint = linkModel.tint.invoke(),
        onClick = {
            linkBrowser.openInBrowser(linkModel.url)
        }
    )
}
