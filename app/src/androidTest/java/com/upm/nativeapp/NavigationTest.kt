package com.upm.nativeapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Rule
import org.junit.Test

class NavigationTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    lateinit var navController: TestNavHostController

    
}