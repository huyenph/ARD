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
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
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
        Firebase.messaging.subscribeToTopic("ard")

        val notificationManager = getSystemService(NotificationManager::class.java)
        val channelId = getString(R.string.notification_channel_id)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
            notificationManager.getNotificationChannel(channelId) == null
        ) {
            val channel = NotificationChannel(
                channelId,
                getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_HIGH,
            )
            notificationManager.createNotificationChannel(channel)
        }
    }
}