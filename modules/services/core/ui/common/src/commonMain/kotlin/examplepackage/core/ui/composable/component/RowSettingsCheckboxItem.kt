package examplepackage.core.ui.composable.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import examplepackage.core.ui.theme.LocalAppTheme

@Composable
fun RowSettingsCheckboxItem(
    text: String,
    checked: Boolean,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    spacing: Dp = LocalAppTheme.current.dimens.S,
    enabled: Boolean = true,
    onCheckChange: (Boolean) -> Unit
) {
    RowSettingItem(
        modifier = modifier,
        text = text,
        prefix = {
            icon?.let { imageVector ->
                Icon(
                    imageVector = imageVector,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.size(LocalAppTheme.current.dimens.M)
                )
            }
        },
        spacing = spacing,
        postfix = {
            Switch(
                checked = checked,
                onCheckedChange = onCheckChange,
                enabled = enabled,
                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colors.secondaryVariant)
            )
        }
    )
}
