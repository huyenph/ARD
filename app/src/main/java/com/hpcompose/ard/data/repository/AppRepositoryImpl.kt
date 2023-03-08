package com.hpcompose.ard.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hpcompose.ard.common.loadJsonFromAssets
import com.hpcompose.ard.di.GsonBuilderLenient
import com.hpcompose.ard.domain.model.LanguageModel
import com.hpcompose.ard.domain.repository.AppRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    @GsonBuilderLenient private val gson: Gson,
) : AppRepository {
    override suspend fun fetchAppLanguages(): List<LanguageModel> {
        val languages: List<LanguageModel>
        withContext(Dispatchers.IO) {
            val languagesJson = loadJsonFromAssets(
                context,
                "languages.json",
                object : TypeToken<List<LanguageModel>>() {}.type,
                gson,
            )
            @Suppress("UNCHECKED_CAST")
            languages = languagesJson as List<LanguageModel>
        }
        return languages
    }
}