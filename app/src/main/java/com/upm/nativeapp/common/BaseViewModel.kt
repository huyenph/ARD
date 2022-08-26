package com.upm.nativeapp.common

import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.upm.nativeapp.data.remote.ApiClient
import com.upm.nativeapp.data.remote.response.ErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.reflect.Type
import javax.inject.Inject

@HiltViewModel
abstract class BaseViewModel {
        open fun onLoading() {

       }


//    override fun onSuccess(code: Int, type: Type?, response: JsonObject) {
//
//    }
//
//    override fun onFailure(code: Int, errorResponse: ErrorResponse) {
//    }
//
//    override fun onNetworkError(code: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onUnknownError(code: Int) {
//        TODO("Not yet implemented")
//    }
}