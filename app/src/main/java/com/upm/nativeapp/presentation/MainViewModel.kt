package com.upm.nativeapp.presentation

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.google.gson.reflect.TypeToken
import com.upm.nativeapp.common.extensions.loadJsonFromAssets
import com.upm.nativeapp.common.helper.LiveEvent
import com.upm.nativeapp.domain.model.LanguageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {
    val appLocale: LiveEvent<String>? = null

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
}