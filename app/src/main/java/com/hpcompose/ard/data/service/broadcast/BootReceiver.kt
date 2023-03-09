package com.hpcompose.ard.data.service.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.hpcompose.ard.data.service.worker.AppAlarmManager
import javax.inject.Inject

class BootReceiver @Inject constructor(private val alarmManager: AppAlarmManager) :
    BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.intent.action.BOOT_COMPLETED") {
            if (alarmManager.canSchedulerExactAlarms()) {
                alarmManager.scheduleRepeatingAlarm()
            }
        }
    }
}