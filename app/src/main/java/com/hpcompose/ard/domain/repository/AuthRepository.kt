package com.hpcompose.ard.domain.repository

import com.google.gson.JsonObject
import com.hpcompose.ard.data.datasource.remote.adapter.NetworkResponse
import com.hpcompose.ard.data.datasource.remote.dto.ErrorResponse

interface AuthRepository {
    suspend fun login(
        username: String,
        password: String
    ): NetworkResponse<JsonObject, ErrorResponse>
}