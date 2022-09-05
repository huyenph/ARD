package com.upm.nativeapp.presentation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.upm.nativeapp.presentation.screens.auth.SignInScreen
import com.upm.nativeapp.presentation.screens.auth.SignUpScreen
import com.upm.nativeapp.presentation.screens.main.MainScreen
import com.upm.nativeapp.presentation.screens.settings.SettingsScreen

interface UpmDestination {
    val icon: ImageVector?
    val route: String
    val screen: @Composable () -> Unit
}

object Main : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "main"
    override val screen: @Composable () -> Unit = { MainScreen() }
}

object SignIn : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "signIn"
    override val screen: @Composable () -> Unit = { SignInScreen() }
}

object SignUp : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "signUp"
    override val screen: @Composable () -> Unit = { SignUpScreen() }
}

object Settings : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "settings"
    override val screen: @Composable () -> Unit = { SettingsScreen() }
}

val upmScreens = listOf(Main, SignIn, SignUp, Settings)