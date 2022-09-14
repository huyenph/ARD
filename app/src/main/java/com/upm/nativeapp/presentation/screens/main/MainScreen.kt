package com.upm.nativeapp.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.upm.nativeapp.R
import com.upm.nativeapp.presentation.components.BaseScaffold
import com.upm.nativeapp.presentation.components.NormalAppBar
import com.upm.nativeapp.presentation.screens.main.components.BottomNavigationBar
import com.upm.nativeapp.presentation.ui.theme.UpmTheme

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val items = listOf(
        NavigationItem.Event,
        NavigationItem.Notification,
        NavigationItem.Settings,
    )
    BaseScaffold(
        topBar = {
            NormalAppBar(
                navIcon = Icons.Outlined.Menu,
                onNavIconClicked = {},
                title = R.string.event,
            )
        },
        bottomBar = { BottomNavigationBar(navController, items) },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MainNavHost(navController = navController)
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun OnMainScreenPreview() {
    UpmTheme {
        MainScreen()
    }
}