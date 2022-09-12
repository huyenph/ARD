package com.upm.nativeapp.presentation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.reflect.TypeToken
import com.upm.nativeapp.common.extensions.PREFS_APP_CONFIGS
import com.upm.nativeapp.common.extensions.loadJsonFromAssets
import com.upm.nativeapp.data.local.storage.Storage
import com.upm.nativeapp.domain.model.AppConfigModel
import com.upm.nativeapp.domain.model.AppConfigType
import com.upm.nativeapp.domain.model.LanguageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val storage: Storage?) : BaseViewModel() {
    private val _appConfig: MutableLiveData<AppConfigModel> by lazy {
        MutableLiveData<AppConfigModel>()
    }
    val appConfig: MutableLiveData<AppConfigModel>
        get() = _appConfig

    init {
        getDefaultConfig()
    }

    fun fetchLanguages(context: Context): List<LanguageModel> {
        var languages: List<LanguageModel> = ArrayList<LanguageModel>()
        launchDataLoad {
            viewModelScope.launch {
                val languagesJson = loadJsonFromAssets(
                    context,
                    "languages.json",
                    object : TypeToken<List<LanguageModel>>() {}.type,
                    gson,
                )
                @Suppress("UNCHECKED_CAST")
                languages = languagesJson as List<LanguageModel>
            }
        }
        return languages
    }

    fun onLanguageChange(language: LanguageModel) {
        _appConfig.value!!.configType = AppConfigType.LANGUAGE
        _appConfig.value!!.language = language
        storage?.setObject(PREFS_APP_CONFIGS, _appConfig.value!!)
        getDefaultConfig()
    }

    private fun getDefaultConfig() {
        val defaultConfig = storage?.getObject(
            key = PREFS_APP_CONFIGS,
            type = object : TypeToken<AppConfigModel>() {}.type
        )
        _appConfig.value =
            if (defaultConfig != null) defaultConfig as AppConfigModel else AppConfigModel()
    }
}