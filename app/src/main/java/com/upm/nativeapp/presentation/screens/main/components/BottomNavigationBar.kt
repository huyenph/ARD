package com.upm.nativeapp.presentation.screens.main.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.upm.nativeapp.presentation.screens.main.NavigationItem
import com.upm.nativeapp.presentation.ui.theme.UpmTheme

@Composable
fun BottomNavigationBar(navController: NavHostController, items: List<NavigationItem>) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                selected = false,
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
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnBottomNavigationBarPreview() {
    UpmTheme {
//        BottomNavigationBar()
    }
}