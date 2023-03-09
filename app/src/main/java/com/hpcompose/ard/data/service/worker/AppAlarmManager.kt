package com.hpcompose.ard.data.service.worker

interface AppAlarmManager {
    fun canSchedulerExactAlarms(): Boolean

    fun scheduleRepeatingAlarm()

    fun clearRepeatingAlarm()
}