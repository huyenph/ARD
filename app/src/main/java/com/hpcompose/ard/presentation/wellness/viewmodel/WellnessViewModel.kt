package com.hpcompose.ard.presentation.wellness.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.hpcompose.ard.presentation.wellness.model.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun removeTask(removedTask: WellnessTask) {
        _tasks.remove(removedTask)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { it.checked = checked }

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(id = i, label = "Task # $i") }
}