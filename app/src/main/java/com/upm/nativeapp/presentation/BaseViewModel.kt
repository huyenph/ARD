package com.upm.nativeapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.upm.nativeapp.data.local.storage.Storage
import com.upm.nativeapp.data.remote.ApiClient
import com.upm.nativeapp.data.remote.ApiResponseListener
import com.upm.nativeapp.data.remote.response.ErrorResponse
import com.upm.nativeapp.di.GsonBuilderLenient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel(), ApiResponseListener {
//    @Inject
//    lateinit var storage: Storage

    @Inject
    @GsonBuilderLenient
    lateinit var gson: Gson

    protected val apiClient by lazy { ApiClient(this) }

    override fun onSuccess(code: Int, type: Type?, response: JsonObject) {
    }

    override fun onFailure(code: Int, errorResponse: ErrorResponse) {
    }

    override fun onNetworkError(code: Int) {
    }

    override fun onUnknownError(code: Int) {
    }

    protected fun launchDataLoad(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {

            }
        }
    }
}