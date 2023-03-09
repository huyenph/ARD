package com.hpcompose.ard.data.service.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.hpcompose.ard.ARDApplication
import com.hpcompose.ard.R
import com.hpcompose.ard.common.playRingtone
import com.hpcompose.ard.common.showNotification

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // TODO: check API first
        if (context != null) {
            showNotification(
                context = context,
                notificationId = 0,
                content = context.getString(R.string.default_placeholder),
            )
            (context.applicationContext as ARDApplication).apply {
                alarmRingtoneState.value = playRingtone(context)
            }
        }
    }
}