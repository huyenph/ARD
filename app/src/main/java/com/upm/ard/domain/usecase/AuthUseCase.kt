package com.upm.ard.domain.usecase

import com.google.gson.JsonObject
import com.upm.ard.data.remote.adapter.NetworkResponse
import com.upm.ard.data.remote.response.ErrorResponse
import com.upm.ard.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun getQuestions(): NetworkResponse<JsonObject, ErrorResponse> =
        authRepository.login("site", "page")
}