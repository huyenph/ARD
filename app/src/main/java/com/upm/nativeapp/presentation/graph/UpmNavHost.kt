package com.upm.nativeapp.presentation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
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
        startDestination = SignIn.route,
        modifier = modifier,
    ) {
        composable(route = Main.route) {
            MainScreen()
        }
        composable(route = SignIn.route) {
            SignInScreen(onRegisterClicked = {
                navController.navigateSingleTopTo(SignUp.route)
            })
        }
        composable(route = SignUp.route) {
            SignUpScreen(onLoginClicked = {
                navController.navigateSingleTopTo(SignIn.route)
            })
        }
        composable(route = Settings.route) {
            SettingsScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }