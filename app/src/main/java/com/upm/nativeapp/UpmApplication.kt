package com.upm.nativeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UpmApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}