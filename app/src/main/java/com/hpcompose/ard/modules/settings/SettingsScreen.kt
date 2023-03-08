package com.hpcompose.ard.modules.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.hpcompose.ard.R
import com.hpcompose.ard.domain.model.AppThemingType
import com.hpcompose.ard.domain.model.LanguageModel
import com.hpcompose.ard.modules.main.MainViewModel
import com.hpcompose.ard.presentation.components.OptionField
import com.hpcompose.ard.presentation.graph.Language
import com.hpcompose.ard.presentation.graph.navigateSingleTopTo

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    appNavController: NavHostController,
    mainViewModel: MainViewModel,
) {
    val appConfig = mainViewModel.appConfig
//    var isDarkMode by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxHeight()
            .wrapContentSize(Alignment.TopCenter)
    ) {
        OptionField(
            onItemClick = { appNavController.navigateSingleTopTo(Language.route) },
            onCheckedChange = null,
            icon = Icons.Outlined.Language,
            title = R.string.language,
            value = appConfig.value?.language ?: LanguageModel(),
            trailing = {
                Row {
                    Text(text = appConfig.value?.language?.language!!)
                    Icon(
                        imageVector = Icons.Outlined.ArrowForwardIos,
                        contentDescription = appConfig.value?.language?.language!!,
                    )
                }
            }
        )
        OptionField(
            onItemClick = {},
            onCheckedChange = { mainViewModel.onThemeChange(it) },
            icon = Icons.Outlined.DarkMode,
            title = R.string.dark_mode,
            value = appConfig.value?.appThemingType == AppThemingType.DARK,
        )
        OptionField(
            onItemClick = {},
            onCheckedChange = { },
            icon = Icons.Outlined.Logout,
            title = R.string.logout,
            value = null,
        )
    }
}