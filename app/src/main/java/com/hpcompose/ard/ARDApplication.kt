package com.hpcompose.ard

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ComponentName
import android.content.pm.PackageManager
import android.media.Ringtone
import android.os.Build
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.hpcompose.ard.data.service.broadcast.BootReceiver
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ARDApplication : Application() {
    val alarmRingtoneState: MutableState<Ringtone?> = mutableStateOf(null)

    override fun onCreate() {
        super.onCreate()
        val receiver = ComponentName(applicationContext, BootReceiver::class.java)
        applicationContext.packageManager.setComponentEnabledSetting(
            receiver,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                getString(R.string.notification_channel_id),
                getString(R.string.default_placeholder),
                NotificationManager.IMPORTANCE_HIGH,
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}