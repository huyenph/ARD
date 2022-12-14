package com.upm.ard.presentation.health.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.upm.ard.presentation.health.screen.HomeScreen
import com.upm.ard.presentation.ui.theme.UpmTheme

@Composable
fun MySootheApp() {
    UpmTheme {
        Scaffold(topBar = { SearchBar() }, bottomBar = { SootheBottomNavigation() }) { padding ->
            HomeScreen(modifier = Modifier.padding(paddingValues = padding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnMySootheAppPreview() {
    UpmTheme {
        MySootheApp()
    }
}