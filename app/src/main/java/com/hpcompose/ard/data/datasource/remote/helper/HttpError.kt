package com.hpcompose.ard.data.datasource.remote.helper

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.hpcompose.ard.core.BaseModel
import okhttp3.Response

class HttpError : BaseModel() {
    @SerializedName("message")
    var message: String? = null
        get() = if (field.isNullOrEmpty()) "fail" else field

    @SerializedName("status_code")
    var code: Int = 0

    companion object {
        fun parseData(json: String): HttpError {
            var httpError: HttpError
            try {
                httpError = Gson().fromJson(json, HttpError::class.java)
                if (httpError != null) {
                    return httpError
                }
            } catch (e: Exception) {
                httpError = HttpError()
                httpError.message = json
            }
            return httpError
        }

        fun getErrorString(response: Response): String {
            val httpError = HttpError()
            httpError.code = response.code
            if (response.body != null) {
                val body = response.body.toString()
                if (!body.startsWith("<!DOCTYPE HTML>")) {
                    httpError.message = body
                } else {
                    httpError.message = ""
                }
            }
            return httpError.toString()
        }

        override fun toString(): String = Gson().toJson(this)
    }
}