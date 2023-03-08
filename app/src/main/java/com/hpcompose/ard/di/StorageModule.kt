package com.hpcompose.ard.di

import com.hpcompose.ard.data.datasource.local.storage.SharedPrefsStorage
import com.hpcompose.ard.data.datasource.local.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    abstract fun provideStorage(sharedPreferences: SharedPrefsStorage): Storage
}