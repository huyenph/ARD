package com.hpcompose.ard

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import org.junit.Rule

class NavigationTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    lateinit var navController: TestNavHostController

    
}