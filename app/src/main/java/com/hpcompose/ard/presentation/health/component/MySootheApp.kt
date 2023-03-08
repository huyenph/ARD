package com.hpcompose.ard.presentation.health.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hpcompose.ard.presentation.health.screen.HomeScreen
import com.hpcompose.ard.presentation.ui.theme.ARDTheme

@Composable
fun MySootheApp() {
    ARDTheme {
        Scaffold(topBar = { SearchBar() }, bottomBar = { SootheBottomNavigation() }) { padding ->
            HomeScreen(modifier = Modifier.padding(paddingValues = padding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnMySootheAppPreview() {
    ARDTheme {
        MySootheApp()
    }
}