package com.upm.nativeapp.presentation.screens.main.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upm.nativeapp.R
import com.upm.nativeapp.presentation.ui.theme.UpmTheme

//sealed class DrawerScreen(@StringRes val title: Int) {
//    object Event : DrawerScreen(R.string.event)
//    object Notification : DrawerScreen(R.string.notification)
//    object Settings : DrawerScreen(R.string.settings)
//}
//
//private val screens = listOf(
//    DrawerScreen.Event,
//    DrawerScreen.Notification,
//    DrawerScreen.Settings,
//)
//
//@Composable
//fun Drawer(
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier
//            .fillMaxSize()
//            .padding(start = 24.dp, top = 48.dp)
//    ) {
//        screens.forEach { screen ->
//            Spacer(Modifier.height(24.dp))
//            Text(
//                text = stringResource(id = screen.title),
//                style = MaterialTheme.typography.h4
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun OnDrawerPreview() {
//    UpmTheme {
//        Drawer()
//    }
//}