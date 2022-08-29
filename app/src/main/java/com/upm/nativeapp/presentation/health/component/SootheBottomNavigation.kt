package com.upm.nativeapp.presentation.health.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.upm.nativeapp.R
import com.upm.nativeapp.presentation.ui.theme.UpmAndroidTheme

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(modifier, backgroundColor = MaterialTheme.colors.background) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnSootheBottomNavigation() {
    UpmAndroidTheme {
        SootheBottomNavigation()
    }
}