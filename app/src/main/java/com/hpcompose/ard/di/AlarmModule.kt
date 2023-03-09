package com.hpcompose.ard.di

import com.hpcompose.ard.data.service.worker.AppAlarmManager
import com.hpcompose.ard.data.service.worker.AppAlarmManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AlarmModule {
    @Binds
    abstract fun provideAppAlarmManager(alarmManagerImpl: AppAlarmManagerImpl): AppAlarmManager
}