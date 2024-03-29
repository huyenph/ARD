package com.hpcompose.ard.data.datasource.local.storage

import com.hpcompose.ard.core.BaseModel
import java.lang.reflect.Type

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String
    fun setInt(key: String, value: Int)
    fun getInt(key: String): Int
    fun setFloat(key: String, value: Float)
    fun getFloat(key: String): Float
    fun setLong(key: String, value: Long)
    fun getLong(key: String): Long
    fun setBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean
    fun setObject(key: String, value: BaseModel)
    fun getObject(key: String, type: Type): BaseModel?
}