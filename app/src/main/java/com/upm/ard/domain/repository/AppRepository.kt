package com.upm.ard.domain.repository

import com.upm.ard.domain.model.LanguageModel

interface AppRepository {
    suspend fun fetchAppLanguages(): List<LanguageModel>
}