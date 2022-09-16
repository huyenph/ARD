package com.upm.ard.presentation.wellness

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upm.ard.presentation.ui.theme.UpmTheme

@Composable
fun WellnessTaskItemState(
    taskName: String,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }
    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = onCheckedChange,
        onClose = onClose,
    )
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnWellnessTaskItemPreview() {
    UpmTheme() {
        WellnessTaskItem(
            taskName = "My Task",
            checked = false,
            onClose = { },
            onCheckedChange = {},
        )
    }
}