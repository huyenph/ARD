package com.upm.nativeapp.common.extensions

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import java.io.IOException
import java.lang.reflect.Type
import java.util.*

@Suppress("DEPRECATION")
fun setLanguage(context: Context, languageCode: String?) {
    val locale = Locale(languageCode ?: "en")
    Locale.setDefault(locale)
    val resources = context.resources
    val configuration = context.resources.configuration
    configuration.setLocale(locale)
    resources.updateConfiguration(configuration, resources.displayMetrics)
}

fun loadJsonFromAssets(context: Context, fileName: String, type: Type?, gson: Gson): Any? {
    try {
//        val inputStream = activity.assets.open(fileName)
//        val size = inputStream.available()
//        val buffer = byt(size)
        context.assets.open(fileName).bufferedReader().use {
            val jsonString = it.readText()
            if (type == null) return jsonString
            return gson.fromJson(jsonString, type)
        }

    } catch (e: IOException) {
        return null
    }
}

