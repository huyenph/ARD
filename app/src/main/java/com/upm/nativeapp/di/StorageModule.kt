package com.upm.nativeapp.di

import android.content.Context
import com.google.gson.Gson
import com.upm.nativeapp.data.local.storage.SharedPreferencesStorage
import com.upm.nativeapp.data.local.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    abstract fun provideStorage(sharedPreferences: SharedPreferencesStorage): Storage
}

//object StorageModule {
//    @Provides
//    @Singleton
//    fun provideStorage(@ApplicationContext context: Context) =
//        context.getSharedPreferences("Storage", Context.MODE_PRIVATE)!!
//}