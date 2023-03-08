package com.hpcompose.ard.core.graph

import androidx.compose.ui.graphics.vector.ImageVector
import com.hpcompose.ard.R

interface UpmDestination {
    val title: Int?
    val icon: ImageVector?
    val route: String
}

object Main : UpmDestination {
    override val title: Int? = null
    override val icon: ImageVector? = null
    override val route: String = "main"
}

object Auth : UpmDestination {
    override val title: Int? = null
    override val icon: ImageVector? = null
    override val route: String = "auth"
}

object Settings : UpmDestination {
    override val title: Int = R.string.settings
    override val icon: ImageVector? = null
    override val route: String = "settings"
}

object Language : UpmDestination {
    override val title: Int = R.string.language
    override val icon: ImageVector? = null
    override val route: String = "language"
}

object Event : UpmDestination {
    override val title: Int = R.string.event
    override val icon: ImageVector? = null
    override val route: String = "event"
}

object Notification : UpmDestination {
    override val title: Int = R.string.notification
    override val icon: ImageVector? = null
    override val route: String = "notification"
}

val upmScreens = listOf(Auth, Main, Settings, Language)