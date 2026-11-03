package examplepackage.features.info.ui.composable.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.makeevrserg.applicationtemplate.modules.services.core.build.konfig.BuildKonfig
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR
import com.makeevrserg.applicationtemplate.modules.services.core.resources.ic_bolt
import com.makeevrserg.applicationtemplate.modules.services.core.resources.info_more_links
import examplepackage.core.ui.common.composable.component.RowSettingTextInfoComposable
import examplepackage.core.ui.common.util.asComposableString
import examplepackage.core.ui.common.util.asPainter
import examplepackage.core.ui.theme.theme.LocalAppTheme
import examplepackage.features.info.ui.composable.component.LinkWidgetComposable
import examplepackage.features.info.ui.composable.component.rememberLinkBrowser
import examplepackage.features.info.ui.link.api.LinkBrowser
import examplepackage.features.info.ui.util.buildInfoScreenLinks

@Composable
fun InfoScreenComposable(modifier: Modifier = Modifier) {
    val linkBrowser: LinkBrowser = rememberLinkBrowser()
    val models = remember { buildInfoScreenLinks() }
    LazyColumn(
        modifier = modifier.padding(horizontal = LocalAppTheme.current.dimens.S)
    ) {
        item {
            Text(
                text = CoreR.strings.info_more_links.asComposableString(),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary,
            )
        }
        items(models) { linkModel ->
            LinkWidgetComposable(
                linkBrowser = linkBrowser,
                linkModel = linkModel
            )
        }
        item {
            RowSettingTextInfoComposable(
                modifier = Modifier.padding(vertical = LocalAppTheme.current.dimens.XS),
                painter = CoreR.images.ic_bolt.asPainter(),
                text = "Version",
                endText = "${BuildKonfig.VERSION_CODE} (${BuildKonfig.VERSION_NAME})"
            )
        }
        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}
