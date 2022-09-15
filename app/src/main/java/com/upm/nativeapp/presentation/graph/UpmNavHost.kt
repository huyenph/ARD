package com.upm.nativeapp.presentation.graph

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.upm.nativeapp.presentation.MainViewModel
import com.upm.nativeapp.presentation.screens.auth.AuthScreen
import com.upm.nativeapp.presentation.screens.main.MainScreen
import com.upm.nativeapp.presentation.screens.settings.LanguageScreen
import com.upm.nativeapp.presentation.screens.settings.SettingsScreen
import javax.inject.Inject

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun UpmNavHost(modifier: Modifier = Modifier, mainViewModel: MainViewModel) {
    val navController = rememberAnimatedNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen =
        upmScreens.find { it.route == currentDestination?.route } ?: Main

    AnimatedNavHost(
        navController = navController,
        startDestination = Auth.route,
        modifier = modifier,
    ) {
        composable(
            route = Main.route,
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
            popEnterTransition = { popEnterTransition },
            popExitTransition = { popExitTransition },
        ) {
            MainScreen(appNavController = navController, mainViewModel = mainViewModel)
        }
        composable(
            route = Auth.route,
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
            popEnterTransition = { popEnterTransition },
            popExitTransition = { popExitTransition },
        ) {
            AuthScreen(navController = navController, onLanguageClicked = {
                navController.navigateSingleTopTo(Language.route)
            })
        }
//        composable(
//            route = Settings.route,
//            enterTransition = { enterTransition },
//            exitTransition = { exitTransition },
//            popEnterTransition = { popEnterTransition },
//            popExitTransition = { popExitTransition },
//        ) {
//            SettingsScreen()
//        }
        composable(
            route = Language.route,
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
            popEnterTransition = { popEnterTransition },
            popExitTransition = { popExitTransition },
        ) {
            LanguageScreen(navController, mainViewModel)
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
