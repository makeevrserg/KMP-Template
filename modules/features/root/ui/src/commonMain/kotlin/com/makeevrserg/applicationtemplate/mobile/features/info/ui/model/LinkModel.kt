package com.makeevrserg.applicationtemplate.mobile.features.info.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ImageResource

class LinkModel(
    val res: ImageResource,
    val title: String,
    val url: String,
    val tint: @Composable () -> Color = { Color.Unspecified }
)
