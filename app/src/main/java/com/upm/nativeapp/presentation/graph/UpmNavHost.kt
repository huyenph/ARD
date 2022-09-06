package com.upm.nativeapp.presentation.graph

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.upm.nativeapp.presentation.screens.auth.SignInScreen
import com.upm.nativeapp.presentation.screens.auth.SignUpScreen
import com.upm.nativeapp.presentation.screens.main.MainScreen
import com.upm.nativeapp.presentation.screens.settings.SettingsScreen

@ExperimentalAnimationApi
@Composable
fun UpmNavHost(modifier: Modifier = Modifier) {
    val navController = rememberAnimatedNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen =
        upmScreens.find { it.route == currentDestination?.route } ?: Main
    AnimatedNavHost(
        navController = navController,
        startDestination = SignIn.route,
        modifier = modifier,
    ) {
        composable(
            route = Main.route,
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
            popEnterTransition = { popEnterTransition },
            popExitTransition = { popExitTransition },
        ) {
            MainScreen()
        }
        composable(
            route = SignIn.route,
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
            popEnterTransition = { popEnterTransition },
            popExitTransition = { popExitTransition },
        ) {
            SignInScreen(onRegisterClicked = {
                navController.navigateSingleTopTo(SignUp.route)
            })
        }
        composable(
            route = SignUp.route,
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
            popEnterTransition = { popEnterTransition },
            popExitTransition = { popExitTransition },
        ) {
            SignUpScreen(onLoginClicked = {
                navController.navigateSingleTopTo(SignIn.route)
            })
        }
        composable(
            route = Settings.route,
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
            popEnterTransition = { popEnterTransition },
            popExitTransition = { popExitTransition },
        ) {
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

val enterTransition =
    slideInHorizontally(
        initialOffsetX = { 300 },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300, easing = FastOutSlowInEasing))


val exitTransition =
    slideOutHorizontally(
        targetOffsetX = { -300 },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300, easing = FastOutSlowInEasing))


val popEnterTransition =
    slideInHorizontally(
        initialOffsetX = { -300 },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300, easing = FastOutSlowInEasing))


val popExitTransition =
    slideOutHorizontally(
        targetOffsetX = { 300 },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300, easing = FastOutSlowInEasing))
