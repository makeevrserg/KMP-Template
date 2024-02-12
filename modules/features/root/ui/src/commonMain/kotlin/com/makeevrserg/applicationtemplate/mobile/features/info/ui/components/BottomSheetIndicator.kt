package com.makeevrserg.applicationtemplate.mobile.features.info.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.makeevrserg.applicationtemplate.mobile.core.ui.theme.AdaptThemeFade
import com.makeevrserg.applicationtemplate.mobile.core.ui.theme.AppTheme

@Composable
internal fun BottomSheetIndicator() {
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

@Preview
@Composable
private fun BottomSheetIndicatorPreview() {
    AdaptThemeFade {
        BottomSheetIndicator()
    }
}
