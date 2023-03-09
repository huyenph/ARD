package com.hpcompose.ard.common

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.accompanist.pager.ExperimentalPagerApi
import com.hpcompose.ard.R
import com.hpcompose.ard.data.service.broadcast.NotificationDismissReceiver
import com.hpcompose.ard.presentation.MainActivity

@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
fun showNotification(
    context: Context,
    notificationId: Int,
    @StringRes title: Int = R.string.default_placeholder,
    @StringRes ticker: Int = R.string.default_placeholder,
    content: String
) {
    val activityIntent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent = PendingIntent.getActivity(
        context, 0, activityIntent, PendingIntent.FLAG_IMMUTABLE
    )
    val deleteIntent = Intent(context, NotificationDismissReceiver::class.java)
    val deletePendingIntent = PendingIntent.getBroadcast(
        context,
        1,
        deleteIntent,
        PendingIntent.FLAG_IMMUTABLE,
    )
    val notification =
        NotificationCompat.Builder(
            context,
            context.getString(R.string.notification_channel_id)
        )
            .setContentTitle(context.getString(title))
            .setTicker(context.getString(ticker))
            .setContentText(content)
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_EVENT)
            .setColor(ContextCompat.getColor(context, R.color.primary_color))
            .setColorized(true)
            .setOngoing(true)
            .setContentIntent(pendingIntent)
            .addAction(
                android.R.drawable.ic_notification_clear_all,
                context.getString(R.string.cancel),
                deletePendingIntent
            )
            .build()

    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager

    notificationManager.notify(notificationId, notification)
}

fun playRingtone(context: Context): Ringtone {
    val alarmUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    val ringtone = RingtoneManager.getRingtone(context.applicationContext, alarmUri)
    ringtone.play()
    return ringtone
}