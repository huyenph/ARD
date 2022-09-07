package com.upm.nativeapp.presentation.graph

import androidx.compose.ui.graphics.vector.ImageVector

interface UpmDestination {
    val icon: ImageVector?
    val route: String
}

object Main : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "main"
}

object Auth : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "auth"
}

object Settings : UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "settings"
}

object Language: UpmDestination {
    override val icon: ImageVector? = null
    override val route: String = "language"

}

val upmScreens = listOf(Auth, Main, Settings)