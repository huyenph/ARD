package com.hpcompose.ard.presentation.screens.main.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hpcompose.ard.presentation.screens.main.NavigationItem
import com.hpcompose.ard.presentation.ui.theme.ARDTheme

@Composable
fun BottomNavigationBar(navController: NavHostController, items: List<NavigationItem>) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.title)
                    )
                },
                label = { Text(text = stringResource(id = item.title)) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnBottomNavigationBarPreview() {
    ARDTheme {
//        BottomNavigationBar()
    }
}