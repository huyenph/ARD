package com.hpcompose.ard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.hpcompose.ard.data.datasource.remote.ApiClient
import com.hpcompose.ard.data.datasource.remote.ApiResponseListener
import com.hpcompose.ard.data.datasource.remote.dto.ErrorResponse
import com.hpcompose.ard.di.GsonBuilderLenient
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
                print(e)
            }
        }
    }
}