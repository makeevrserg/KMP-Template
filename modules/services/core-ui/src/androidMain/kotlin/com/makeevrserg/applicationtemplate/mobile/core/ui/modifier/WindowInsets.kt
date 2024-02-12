package com.makeevrserg.applicationtemplate.mobile.core.ui.modifier

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier

actual fun Modifier.navBarsPadding(): Modifier {
    return then(navigationBarsPadding()).then(systemBarsPadding())
}
