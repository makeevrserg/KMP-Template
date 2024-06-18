package com.makeevrserg.applicationtemplate.mobile.features.info.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.makeevrserg.applicationtemplate.mobile.core.ui.components.rowitem.RowSettingTextInfo
import com.makeevrserg.applicationtemplate.mobile.core.ui.modifier.navBarsPadding
import com.makeevrserg.applicationtemplate.mobile.core.ui.theme.AdaptThemeFade
import com.makeevrserg.applicationtemplate.mobile.core.ui.theme.AppTheme
import com.makeevrserg.applicationtemplate.mobile.core.ui.util.asComposableString
import com.makeevrserg.applicationtemplate.mobile.features.info.linkbrowser.LinkBrowser
import com.makeevrserg.applicationtemplate.mobile.features.info.ui.components.BottomSheetIndicator
import com.makeevrserg.applicationtemplate.mobile.features.info.ui.components.LinkWidget
import com.makeevrserg.applicationtemplate.mobile.features.info.ui.components.rememberLinkBrowser
import com.makeevrserg.applicationtemplate.mobile.features.info.ui.data.InfoScreenLinks
import com.makeevrserg.applicationtemplate.modules.services.build.konfig.BuildKonfig
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR

@Composable
fun InfoScreen(
    isBottomSheet: Boolean
) {
    val linkBrowser: LinkBrowser = rememberLinkBrowser()
    val models = remember { InfoScreenLinks.get() }
    LazyColumn(
        modifier = Modifier
            .navBarsPadding()
            .padding(horizontal = AppTheme.dimens.S)
    ) {
        if (isBottomSheet) {
            item {
                BottomSheetIndicator()
            }
        }
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
                modifier = Modifier.padding(vertical = AppTheme.dimens.XS),
                icon = Icons.Filled.Bolt,
                text = "Version",
                endText = "${BuildKonfig.VERSION_CODE} (${BuildKonfig.VERSION_NAME})"
            )
        }
        item {
            Spacer(modifier = Modifier.height(AppTheme.dimens.M))
        }
    }
}

@Preview
@Composable
private fun InfoScreenPreview() {
    AdaptThemeFade {
        InfoScreen(isBottomSheet = false)
    }
}
