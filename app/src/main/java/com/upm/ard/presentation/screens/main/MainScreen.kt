package com.upm.ard.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.DrawerValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.upm.ard.presentation.MainViewModel
import com.upm.ard.presentation.components.BaseScaffold
import com.upm.ard.presentation.components.NormalAppBar
import com.upm.ard.presentation.screens.main.components.BottomNavigationBar
import com.upm.ard.presentation.screens.main.components.NavigationDrawer
import com.upm.ard.presentation.ui.theme.UpmTheme
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    appNavController: NavHostController,
    mainViewModel: MainViewModel,
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val mainNavController = rememberNavController()
    val scope = rememberCoroutineScope()
    val items = listOf(
        NavigationItem.Event,
        NavigationItem.Notification,
        NavigationItem.Settings,
    )
    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: items[0].route
    BaseScaffold(
        scaffoldState = scaffoldState,
        topBar = {
            NormalAppBar(
                navIcon = Icons.Outlined.Menu,
                onNavIconClicked = { scope.launch { scaffoldState.drawerState.open() } },
                title = items.find { it.route == currentRoute }!!.title,
            )
        },
        drawerContent = {
            NavigationDrawer(
                scope = scope,
                scaffoldState = scaffoldState,
                navController = mainNavController,
                items = items,
            )
        },
        bottomBar = { BottomNavigationBar(mainNavController, items) },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MainNavHost(
                    navController = mainNavController,
                    appNavController = appNavController,
                    mainViewModel = mainViewModel,
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun OnMainScreenPreview() {
    UpmTheme {
//        MainScreen()
    }
}