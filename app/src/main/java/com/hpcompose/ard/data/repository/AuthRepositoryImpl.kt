package com.hpcompose.ard.data.repository

import android.util.Log
import com.google.gson.JsonObject
import com.hpcompose.ard.data.datasource.remote.ApiService
import com.hpcompose.ard.data.datasource.remote.adapter.NetworkResponse
import com.hpcompose.ard.data.datasource.remote.dto.ErrorResponse
import com.hpcompose.ard.di.UnAuthNetworkService
import com.hpcompose.ard.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    @UnAuthNetworkService private val apiService: ApiService
) : AuthRepository {
    override suspend fun login(
        username: String,
        password: String
    ): NetworkResponse<JsonObject, ErrorResponse> {
        val jsonObject = withContext(Dispatchers.IO) {
//            val map = HashMap<String, Any>()
//            map["username"] = username
//            map["password"] = password
//            apiService.requestLogin(map)
            Log.d("test", "execute here")
            apiService.getQuestions("stackoverflow", 1)
        }
        return jsonObject
    }
}