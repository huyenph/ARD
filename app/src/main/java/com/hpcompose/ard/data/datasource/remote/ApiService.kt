package com.hpcompose.ard.data.datasource.remote

import com.google.gson.JsonObject
import com.hpcompose.ard.data.datasource.remote.adapter.NetworkResponse
import com.hpcompose.ard.data.datasource.remote.dto.ErrorResponse
import com.hpcompose.ard.core.BaseModel
import okhttp3.RequestBody
import retrofit2.http.*

typealias GenericResponse<S> = NetworkResponse<S, ErrorResponse>

interface ApiService {
    @GET("users")
    fun requestUserSE(
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("site") site: String,
        @Query("page") page: Int
    ): GenericResponse<JsonObject>

    @FormUrlEncoded
    @POST("")
    fun requestLogin(@FieldMap body: Map<String, Any>): GenericResponse<JsonObject>

    @FormUrlEncoded
    @POST("key, object")
    fun requestNormal(@FieldMap body: Map<String, Any>): GenericResponse<JsonObject>

    @POST("storeList")
    fun requestList(@Body list: List<BaseModel>): GenericResponse<JsonObject>

    @GET("not params")
    fun requestNotParams(): GenericResponse<JsonObject>

    @POST("upload file")
    fun requestFile(@Body file: RequestBody): GenericResponse<JsonObject>

    @GET("questions")
    suspend fun getQuestions(
        @Query("site") site: String,
        @Query("page") page: Int
    ): GenericResponse<JsonObject>
}