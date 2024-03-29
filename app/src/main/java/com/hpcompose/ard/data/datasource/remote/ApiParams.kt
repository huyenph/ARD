package com.hpcompose.ard.data.datasource.remote

class ApiParams {
    private val params = HashMap<String, Any>()
    fun add(key: String, value: Any) = params.put(key, value)
    fun getParams(): Map<String, Any> = params
}