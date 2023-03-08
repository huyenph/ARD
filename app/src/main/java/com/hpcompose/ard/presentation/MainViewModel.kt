package com.hpcompose.ard.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.gson.reflect.TypeToken
import com.hpcompose.ard.common.PREFS_APP_CONFIGS
import com.hpcompose.ard.data.local.storage.Storage
import com.hpcompose.ard.domain.model.AppConfigModel
import com.hpcompose.ard.domain.model.AppConfigType
import com.hpcompose.ard.domain.model.AppThemingType
import com.hpcompose.ard.domain.model.LanguageModel
import com.hpcompose.ard.domain.usecase.AppUseCase
import com.hpcompose.ard.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val storage: Storage?,
    private val appUseCase: AppUseCase,
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {
    private val _appConfig: MutableStateFlow<AppConfigModel> = MutableStateFlow(AppConfigModel())
    val appConfig: StateFlow<AppConfigModel> = _appConfig

    private val _str = MutableStateFlow(0)
    val str: StateFlow<Int> = _str

    init {
        getDefaultConfig()
    }

    fun login() {
        launchDataLoad {
            authUseCase.getQuestions()
        }
        Log.d("test", "down here")
    }

    fun fetchLanguages(): List<LanguageModel> {
        var languages: List<LanguageModel> = ArrayList()
        launchDataLoad {
            languages = appUseCase.fetchAppLanguages()
        }
        return languages
    }

    fun onLanguageChange(language: LanguageModel) {
        val languageConfig = AppConfigModel(
            language = _appConfig.value.language,
            appThemingType = _appConfig.value.appThemingType,
            configType = _appConfig.value.configType
        )
        languageConfig.configType = AppConfigType.LANGUAGE
        languageConfig.language = language
        storage?.setObject(PREFS_APP_CONFIGS, languageConfig)
        getDefaultConfig()
    }

    fun onThemeChange(isDarkMode: Boolean) {
        val themeConfig = AppConfigModel(
            language = _appConfig.value.language,
            appThemingType = _appConfig.value.appThemingType,
            configType = _appConfig.value.configType
        )
        themeConfig.configType = AppConfigType.THEME
        themeConfig.appThemingType =
            if (isDarkMode) AppThemingType.DARK else AppThemingType.LIGHT
        storage?.setObject(PREFS_APP_CONFIGS, themeConfig)
        getDefaultConfig()
    }

    private fun getDefaultConfig() {
        val defaultConfig = storage?.getObject(
            key = PREFS_APP_CONFIGS,
            type = object : TypeToken<AppConfigModel>() {}.type
        )
        val config =
            if (defaultConfig != null) defaultConfig as AppConfigModel else AppConfigModel()
        viewModelScope.launch {
//             _appConfig.update {
//                it.copy(
//                    language = config.language,
//                    appThemingType = config.appThemingType,
//                    configType = config.configType,
//                )
//            }
            _appConfig.value =
                if (defaultConfig != null) defaultConfig as AppConfigModel else AppConfigModel()
//            _appConfig.value = AppConfigModel(
//                language = LanguageModel(
//                    language = "Viet Nam",
//                    description = "VN",
//                    locale = "vi"
//                )
//            )
        }
//        launchDataLoad {

//            if (defaultConfig != null) defaultConfig as AppConfigModel else AppConfigModel()
//        }
    }
}