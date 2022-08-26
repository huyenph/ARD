package com.upm.nativeapp.domain.repository

import com.google.gson.JsonObject
import com.upm.nativeapp.data.remote.adapter.NetworkResponse
import com.upm.nativeapp.data.remote.response.ErrorResponse

interface AuthRepository {
    suspend fun login(
        username: String,
        password: String
    ): NetworkResponse<JsonObject, ErrorResponse>
}