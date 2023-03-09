package com.hpcompose.ard.di

import com.hpcompose.ard.data.service.broadcast.BootReceiver
import com.hpcompose.ard.data.service.worker.AppAlarmManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun provideBootReceiver(alarmManager: AppAlarmManager) = BootReceiver(alarmManager)
}