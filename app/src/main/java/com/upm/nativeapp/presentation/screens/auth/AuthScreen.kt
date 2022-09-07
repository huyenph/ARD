package com.upm.nativeapp.presentation.screens.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.upm.nativeapp.presentation.components.BaseScaffold
import com.upm.nativeapp.presentation.screens.auth.components.AuthAppBar
import com.upm.nativeapp.presentation.ui.theme.backgroundLightColor
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun AuthScreen(navController: NavHostController, onLanguageClicked: () -> Unit) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    var pageIndex by rememberSaveable { mutableStateOf(0) }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            pageIndex = page
        }
    }

    BaseScaffold(
        backgroundColor = backgroundLightColor,
        topBar = { AuthAppBar(onLanguageClicked = onLanguageClicked) },
    ) { _ ->
        HorizontalPager(
            count = 2,
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> SignInForm(
                    onRegisterClicked = {
                        coroutineScope.launch {
                            pageIndex = 1
                            pagerState.animateScrollToPage(page = pageIndex)
                        }
                    }
                )
                else -> SignUpForm(
                    onLoginClicked = {
                        coroutineScope.launch {
                            pageIndex = 0
                            pagerState.animateScrollToPage(page = pageIndex)
                        }
                    }
                )
            }
        }
    }
}