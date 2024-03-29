package com.hpcompose.ard.domain.usecase

import com.google.gson.JsonObject
import com.hpcompose.ard.data.datasource.remote.adapter.NetworkResponse
import com.hpcompose.ard.data.datasource.remote.dto.ErrorResponse
import com.hpcompose.ard.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun getQuestions(): NetworkResponse<JsonObject, ErrorResponse> =
        authRepository.login("site", "page")
}