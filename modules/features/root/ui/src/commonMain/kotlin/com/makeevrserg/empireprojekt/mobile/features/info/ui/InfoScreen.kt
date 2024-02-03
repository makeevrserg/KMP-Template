package com.makeevrserg.empireprojekt.mobile.features.info.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.makeevrserg.empireprojekt.mobile.buildkonfig.BuildKonfig
import com.makeevrserg.empireprojekt.mobile.core.ui.asComposableString
import com.makeevrserg.empireprojekt.mobile.core.ui.components.RowSettingTextInfo
import com.makeevrserg.empireprojekt.mobile.core.ui.components.navBarsPadding
import com.makeevrserg.empireprojekt.mobile.core.ui.theme.AppTheme
import com.makeevrserg.empireprojekt.mobile.resources.MR

@Composable
fun InfoScreen() {
    LazyColumn(
        modifier = Modifier
            .navBarsPadding()
            .padding(horizontal = AppTheme.dimens.S)
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    Modifier
                        .fillMaxWidth(0.4f)
                        .height(AppTheme.dimens.XS)
                        .clip(RoundedCornerShape(AppTheme.dimens.L))
                        .background(MaterialTheme.colors.onPrimary)
                )
            }
        }
        item {
            Text(
                text = MR.strings.info_more_links.asComposableString(),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary,
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
