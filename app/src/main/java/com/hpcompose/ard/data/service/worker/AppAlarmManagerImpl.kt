package com.hpcompose.ard.data.service.worker

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.SystemClock
import com.hpcompose.ard.data.service.broadcast.AlarmReceiver
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

const val ALARM_INTERVAL: Long = 1 * 60 * 1000

@Singleton
class AppAlarmManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AppAlarmManager {
    private val alarmManager: AlarmManager =
        context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    private val alarmIntent: PendingIntent =
        Intent(context, AlarmReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        }

    override fun canSchedulerExactAlarms(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            alarmManager.canScheduleExactAlarms()
        } else {
            true
        }
    }

    override fun scheduleRepeatingAlarm() {
        clearRepeatingAlarm()
        alarmManager.setInexactRepeating(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + ALARM_INTERVAL,
            ALARM_INTERVAL,
            alarmIntent
        )
    }

    override fun clearRepeatingAlarm() {
        alarmManager.cancel(alarmIntent)
    }
}