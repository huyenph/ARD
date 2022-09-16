package com.upm.ard.presentation.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.upm.ard.presentation.MainViewModel
import com.upm.ard.presentation.screens.event.EventScreen
import com.upm.ard.presentation.screens.notification.NotificationScreen
import com.upm.ard.presentation.screens.settings.SettingsScreen

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