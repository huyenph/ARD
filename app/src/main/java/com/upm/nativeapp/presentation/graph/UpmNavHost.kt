package com.upm.nativeapp.presentation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.upm.nativeapp.presentation.screens.auth.SignInScreen
import com.upm.nativeapp.presentation.screens.auth.SignUpScreen
import com.upm.nativeapp.presentation.screens.main.MainScreen
import com.upm.nativeapp.presentation.screens.settings.SettingsScreen

@Composable
fun UpmNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Main.route,
        modifier = modifier,
    ) {
        composable(route = Main.route) {
            MainScreen()
        }
        composable(route = SignIn.route) {
            SignInScreen()
        }
        composable(route = SignUp.route) {
            SignUpScreen()
        }
        composable(route = Settings.route) {
            SettingsScreen()
        }
    }
}