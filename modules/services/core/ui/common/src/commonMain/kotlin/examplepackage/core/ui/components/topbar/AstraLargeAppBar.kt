package examplepackage.core.ui.components.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR
import examplepackage.core.ui.util.asPainter

@Composable
fun AstraCenterAlignedTopAppBar(
    title: String = "",
    onBackClicked: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    AstraCenterAlignedTopAppBar(
        onBackClicked = onBackClicked,
        actions = actions,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AstraCenterAlignedTopAppBar(
    title: @Composable () -> Unit,
    onBackClicked: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        actions = actions,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
        ),
        title = title,
        navigationIcon = {
            onBackClicked?.let {
                IconButton(onClick = it) {
                    Icon(
                        painter = CoreR.images.ic_chevron_right.asPainter(),
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    )
}
