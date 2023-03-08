package com.hpcompose.ard.data.datasource

import android.util.Log
import com.google.gson.JsonObject
import com.hpcompose.ard.data.remote.ApiService
import com.hpcompose.ard.data.remote.adapter.NetworkResponse
import com.hpcompose.ard.data.remote.response.ErrorResponse
import com.hpcompose.ard.di.UnAuthNetworkService
import com.hpcompose.ard.domain.repository.AuthRepository
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