package com.upm.nativeapp.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.reflect.TypeToken
import com.upm.nativeapp.common.extensions.PREFS_APP_CONFIGS
import com.upm.nativeapp.common.extensions.loadJsonFromAssets
import com.upm.nativeapp.domain.model.AppConfigModel
import com.upm.nativeapp.domain.model.AppConfigType
import com.upm.nativeapp.domain.model.LanguageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {
    private val _appLocale: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val appLocale: LiveData<String>
        get() = _appLocale

    private val _appConfig: MutableLiveData<AppConfigModel> by lazy {
        MutableLiveData<AppConfigModel>()
    }
    val appConfig: MutableLiveData<AppConfigModel>
        get() = _appConfig

    init {
        appConfig.value = storage.getObject(
            key = PREFS_APP_CONFIGS,
            type = object : TypeToken<AppConfigModel>() {}.type
        ) as AppConfigModel
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
        _appLocale.value = language.locale
        _appConfig.value!!.configType = AppConfigType.LANGUAGE
        _appConfig.value!!.language = language
    }
}