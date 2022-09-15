package com.upm.nativeapp.presentation

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.google.gson.reflect.TypeToken
import com.upm.nativeapp.common.extensions.PREFS_APP_CONFIGS
import com.upm.nativeapp.common.extensions.loadJsonFromAssets
import com.upm.nativeapp.data.local.storage.Storage
import com.upm.nativeapp.domain.model.AppConfigModel
import com.upm.nativeapp.domain.model.AppConfigType
import com.upm.nativeapp.domain.model.AppThemingType
import com.upm.nativeapp.domain.model.LanguageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val storage: Storage?) : BaseViewModel() {
    private val _appConfig: MutableStateFlow<AppConfigModel> = MutableStateFlow(AppConfigModel())
    val appConfig: StateFlow<AppConfigModel> = _appConfig

    private val _str = MutableStateFlow(0)
    val str: StateFlow<Int> = _str

    init {
        getDefaultConfig()
    }

    fun fetchLanguages(context: Context): List<LanguageModel> {
        var languages: List<LanguageModel> = ArrayList()
//        launchDataLoad {
            val languagesJson = loadJsonFromAssets(
                context,
                "languages.json",
                object : TypeToken<List<LanguageModel>>() {}.type,
                gson,
            )
            @Suppress("UNCHECKED_CAST")
            languages = languagesJson as List<LanguageModel>
//        }
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