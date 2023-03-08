package com.hpcompose.ard.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OptionField(
    onItemClick: () -> Unit?,
    onCheckedChange: ((Boolean) -> Unit)?,
    icon: ImageVector,
    @StringRes title: Int,
    value: Any?,
    trailing: @Composable () -> Unit = {},
) {
    val modifier = Modifier.fillMaxWidth()
    ListItem(
        modifier = if (value is Boolean) {
            modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() } // This is mandatory
            ) {
                onItemClick()
            }
        } else {
            modifier.clickable { onItemClick() }
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = stringResource(id = title),
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )
        },
        text = { Text(stringResource(id = title)) },
        trailing = {
            when (value) {
                is Boolean -> {
                    Switch(checked = value, onCheckedChange = onCheckedChange)
                }
                else -> trailing()
            }
        }
    )
}

inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}