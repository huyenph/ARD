package com.upm.ard.data.local.storage

import android.content.Context
import com.google.gson.Gson
import com.upm.ard.di.GsonBuilderLenient
import com.upm.ard.domain.model.BaseModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesStorage @Inject constructor(
    @ApplicationContext context: Context,
    @GsonBuilderLenient private val gson: Gson,
) : Storage {
    private val _sharedPrefs = context.getSharedPreferences("Storage", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) = with(_sharedPrefs.edit()) {
        putString(key, value)
        apply()
    }

    override fun getString(key: String): String = _sharedPrefs.getString(key, "")!!

    override fun setInt(key: String, value: Int) = with(_sharedPrefs.edit()) {
        putInt(key, value)
        apply()
    }

    override fun getInt(key: String): Int = _sharedPrefs.getInt(key, 0)

    override fun setFloat(key: String, value: Float) = with(_sharedPrefs.edit()) {
        putFloat(key, value)
        apply()
    }

    override fun getFloat(key: String): Float = _sharedPrefs.getFloat(key, 0F)

    override fun setLong(key: String, value: Long) = with(_sharedPrefs.edit()) {
        putLong(key, value)
        apply()
    }

    override fun getLong(key: String): Long = _sharedPrefs.getLong(key, 0)

    override fun setBoolean(key: String, value: Boolean) = with(_sharedPrefs.edit()) {
        putBoolean(key, value)
        apply()
    }

    override fun getBoolean(key: String): Boolean = _sharedPrefs.getBoolean(key, false)

    override fun setObject(key: String, value: BaseModel) = with(_sharedPrefs.edit()) {
        val json = gson.toJson(value)
        putString(key, json)
        apply()
    }

    override fun getObject(key: String, type: Type): BaseModel? {
        val data = _sharedPrefs.getString(key, "")
        if(data != null && data.isNotEmpty()) {
            return gson.fromJson(data, type)
        }
        return null
    }
}