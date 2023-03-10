package com.hpcompose.ard.presentation

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.hpcompose.ard.R
import com.hpcompose.ard.common.setLanguage
import com.hpcompose.ard.domain.model.AppConfigType
import com.hpcompose.ard.domain.model.AppThemingType
import com.hpcompose.ard.core.graph.UpmNavHost
import com.hpcompose.ard.data.service.worker.AppAlarmManager
import com.hpcompose.ard.presentation.ui.theme.ARDTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalPermissionsApi::class)
@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainVM: MainViewModel by viewModels()

    @Inject
    lateinit var alarmManager: AppAlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainVM.appConfig.collect() {
                    if (it.configType == AppConfigType.LANGUAGE || it.configType == AppConfigType.DEFAULT) {
                        setLanguage(this@MainActivity, it.language.locale)
                    }
                    if (it.configType == AppConfigType.THEME || it.configType == AppConfigType.DEFAULT) {
                        window.statusBarColor = ContextCompat.getColor(
                            applicationContext,
                            if (it.appThemingType == AppThemingType.DARK) R.color.background_dark
                            else R.color.background_light
                        )
                    }
                }
            }
        }
        setContent {
            val permissionsStates =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    rememberMultiplePermissionsState(
                        permissions = listOf(Manifest.permission.POST_NOTIFICATIONS),
                        onPermissionsResult = { results: Map<String, Boolean> ->

                        },
                    )
                } else {
                    null
                }

            LaunchedEffect(true) {
                permissionsStates?.launchMultiplePermissionRequest()
            }

            setRepeatingAlarm()

            val themeState = mainVM.appConfig.collectAsState().value.appThemingType
            ARDTheme(darkTheme = themeState == AppThemingType.DARK) {
                UpmNavHost(mainViewModel = mainVM)
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        setRepeatingAlarm()
    }

    private fun setRepeatingAlarm() {
        if (alarmManager.canSchedulerExactAlarms()) {
            alarmManager.scheduleRepeatingAlarm()
        }
    }
}
