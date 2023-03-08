package com.hpcompose.ard.modules.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hpcompose.ard.modules.event.EventScreen
import com.hpcompose.ard.modules.notification.NotificationScreen
import com.hpcompose.ard.modules.settings.SettingsScreen
import com.hpcompose.ard.presentation.MainViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    appNavController: NavHostController,
    mainViewModel: MainViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Event.route,
    ) {
        composable(NavigationItem.Event.route) {
            EventScreen()
        }
        composable(NavigationItem.Notification.route) {
            NotificationScreen()
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen(appNavController = appNavController, mainViewModel = mainViewModel)
        }
    }
}