package com.upm.nativeapp.presentation.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.upm.nativeapp.presentation.wellness.viewmodel.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier, wellnessViewModel: WellnessViewModel = viewModel(),
) {
    Column(modifier = Modifier) {
        WaterCounterState(modifier)
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedChanged = { task, checked ->
                wellnessViewModel.changeTaskChecked(
                    task,
                    checked
                )
            },
            onCloseTask = { task -> wellnessViewModel.removeTask(task) })
    }
}