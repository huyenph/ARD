package com.upm.ard.domain.usecase

import com.upm.ard.domain.model.LanguageModel
import com.upm.ard.domain.repository.AppRepository
import javax.inject.Inject

class AppUseCase @Inject constructor(private val appRepository: AppRepository) {
    suspend fun fetchAppLanguages(): List<LanguageModel> = appRepository.fetchAppLanguages()
}