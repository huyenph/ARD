package com.upm.nativeapp.data.datasource

import com.google.gson.JsonObject
import com.upm.nativeapp.data.remote.ApiService
import com.upm.nativeapp.data.remote.adapter.NetworkResponse
import com.upm.nativeapp.data.remote.response.ErrorResponse
import com.upm.nativeapp.di.UnAuthNetworkService
import com.upm.nativeapp.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    @UnAuthNetworkService private val apiService: ApiService
) : AuthRepository {
    override suspend fun login(
        username: String,
        password: String
    ): NetworkResponse<JsonObject, ErrorResponse> {
        val jsonObject = withContext(Dispatchers.IO) {
            val map = HashMap<String, Any>()
            map["username"] = username
            map["password"] = password
            apiService.requestLogin(map)
        }
        return jsonObject
    }
}