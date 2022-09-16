package com.upm.ard.domain.repository

import com.google.gson.JsonObject
import com.upm.ard.data.remote.adapter.NetworkResponse
import com.upm.ard.data.remote.response.ErrorResponse

interface AuthRepository {
    suspend fun login(
        username: String,
        password: String
    ): NetworkResponse<JsonObject, ErrorResponse>
}