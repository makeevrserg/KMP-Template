package examplepackage.features.info.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import examplepackage.core.ui.components.rowitem.RowSettingTextInfo
import examplepackage.core.ui.modifier.navBarsPadding
import examplepackage.core.ui.theme.AdaptThemeFade
import examplepackage.core.ui.util.asComposableString
import examplepackage.features.info.linkbrowser.LinkBrowser
import examplepackage.features.info.ui.components.LinkWidget
import examplepackage.features.info.ui.components.rememberLinkBrowser
import examplepackage.features.info.ui.data.InfoScreenLinks
import com.makeevrserg.applicationtemplate.modules.services.build.konfig.BuildKonfig
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR

@Composable
fun InfoScreen() {
    val linkBrowser: LinkBrowser = rememberLinkBrowser()
    val models = remember { InfoScreenLinks.get() }
    LazyColumn(
        modifier = Modifier.padding(horizontal = LocalAppTheme.current.dimens.S)
    ) {
        item {
            Text(
                text = CoreR.strings.info_more_links.asComposableString(),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary,
            )
        }
        items(models) { linkModel ->
            LinkWidget(
                linkBrowser = linkBrowser,
                linkModel = linkModel
            )
        }
        item {
            RowSettingTextInfo(
                modifier = Modifier.padding(vertical = LocalAppTheme.current.dimens.XS),
                icon = Icons.Filled.Bolt,
                text = "Version",
                endText = "${BuildKonfig.VERSION_CODE} (${BuildKonfig.VERSION_NAME})"
            )
        }
        item {
            Spacer(modifier = Modifier.navBarsPadding())
        }
    }
}

@Preview
@Composable
private fun InfoScreenPreview() {
    AdaptThemeFade {
        InfoScreen()
    }
}
