package com.upm.ard.data.datasource

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.upm.ard.common.extensions.loadJsonFromAssets
import com.upm.ard.di.GsonBuilderLenient
import com.upm.ard.domain.model.LanguageModel
import com.upm.ard.domain.repository.AppRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDataSource @Inject constructor(
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