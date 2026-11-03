package examplepackage.core.ui.common.composable.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR
import com.makeevrserg.applicationtemplate.modules.services.core.resources.ic_chevron_right
import dev.icerock.moko.resources.ImageResource
import examplepackage.core.ui.common.util.asPainter
import examplepackage.core.ui.theme.theme.LocalAppTheme

@Composable
fun RowSettingChevronItemComposable(
    text: String,
    modifier: Modifier = Modifier,
    spacing: Dp = LocalAppTheme.current.dimens.S,
    prefix: (@Composable RowScope.() -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    RowSettingItemComposable(
        modifier = modifier,
        text = text,
        spacing = spacing,
        prefix = prefix,
        postfix = {
            IconButton(onClick = onClick) {
                Icon(
                    painter = CoreR.images.ic_chevron_right.asPainter(),
                    contentDescription = null,
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.size(LocalAppTheme.current.dimens.M)
                )
            }
        },
    )
}

@Composable
fun RowSettingChevronItemComposable(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    spacing: Dp = LocalAppTheme.current.dimens.S,
    onClick: (() -> Unit) = {}
) {
    RowSettingChevronItemComposable(
        modifier = modifier,
        text = text,
        onClick = onClick,
        spacing = spacing,
        prefix = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier.size(LocalAppTheme.current.dimens.M)
            )
        }
    )
}

@Composable
fun RowSettingTextInfoComposable(
    painter: Painter,
    text: String,
    endText: String,
    modifier: Modifier = Modifier,
    spacing: Dp = LocalAppTheme.current.dimens.S,
) {
    RowSettingItemComposable(
        modifier = modifier,
        text = text,
        spacing = spacing,
        prefix = {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier.size(LocalAppTheme.current.dimens.M)
            )
        },
        postfix = {
            Text(
                text = endText,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.padding(end = LocalAppTheme.current.dimens.M)
            )
        },
    )
}

@Composable
fun RowSettingChevronItemComposable(
    icon: ImageResource,
    text: String,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    onClick: (() -> Unit) = {}
) {
    RowSettingChevronItemComposable(
        modifier = modifier,
        text = text,
        onClick = onClick,
        prefix = {
            Icon(
                painter = icon.asPainter(),
                contentDescription = null,
                tint = tint,
                modifier = Modifier.size(LocalAppTheme.current.dimens.M)
            )
        }
    )
}
