package com.hpcompose.ard.domain.repository

import com.hpcompose.ard.domain.model.LanguageModel

interface AppRepository {
    suspend fun fetchAppLanguages(): List<LanguageModel>
}