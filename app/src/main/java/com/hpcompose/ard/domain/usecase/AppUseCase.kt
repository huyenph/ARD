package com.hpcompose.ard.domain.usecase

import com.hpcompose.ard.domain.model.LanguageModel
import com.hpcompose.ard.domain.repository.AppRepository
import javax.inject.Inject

class AppUseCase @Inject constructor(private val appRepository: AppRepository) {
    suspend fun fetchAppLanguages(): List<LanguageModel> = appRepository.fetchAppLanguages()
}