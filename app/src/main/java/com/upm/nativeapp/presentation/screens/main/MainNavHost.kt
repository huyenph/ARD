package com.upm.nativeapp.presentation.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.upm.nativeapp.presentation.MainViewModel
import com.upm.nativeapp.presentation.screens.event.EventScreen
import com.upm.nativeapp.presentation.screens.notification.NotificationScreen
import com.upm.nativeapp.presentation.screens.settings.SettingsScreen
import javax.inject.Inject

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