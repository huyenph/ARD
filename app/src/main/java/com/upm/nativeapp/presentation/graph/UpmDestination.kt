package com.upm.nativeapp.presentation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

interface UpmDestination {
    val icon: ImageVector?
    val route: String
    val screen: @Composable () -> Unit
}

object Main : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "main"
    override val screen: () -> Unit = {}
}

object SignIn : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "signIn"
    override val screen: () -> Unit = {}
}

object SignUp : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "signUp"
    override val screen: () -> Unit = {}
}

object Settings : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "settings"
    override val screen: () -> Unit = {}
}