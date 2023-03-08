package com.hpcompose.ard.presentation.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hpcompose.ard.presentation.ui.theme.UpmTheme

@Composable
fun WaterCounter(
    count: Int,
    onIncrement: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItemState(
                    onClose = { },
                    taskName = "Have you taken your 15 minute walk today?",
                    onCheckedChange = {}
                )
            }
            Text(text = "You've had $count glasses.")
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = onIncrement, enabled = count < 10) {
                Text(text = "Add one")
            }
            Button(onClick = onReset, Modifier.padding(start = 8.dp)) {
                Text(text = "Clear water count")
            }
        }
    }
}

@Composable
fun WaterCounterState(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    WaterCounter(
        count = count,
        onIncrement = { count++ },
        onReset = { count = 0 },
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun OnWaterCountPreview() {
    UpmTheme {
        WaterCounter(count = 0, onIncrement = {}, onReset = {})
    }
}