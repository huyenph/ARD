package com.upm.nativeapp.presentation.screens.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.upm.nativeapp.R

sealed class NavigationItem(var route: String, var icon: ImageVector, @StringRes var title: Int) {
    object Event : NavigationItem("event", Icons.Outlined.Event, R.string.event)
    object Notification :
        NavigationItem("notification", Icons.Outlined.Notifications, R.string.notification)

    object Settings : NavigationItem("settings", Icons.Outlined.Settings, R.string.settings)
}
