package com.hpcompose.ard.di

import com.hpcompose.ard.data.repository.AppRepositoryImpl
import com.hpcompose.ard.data.repository.AuthRepositoryImpl
import com.hpcompose.ard.domain.repository.AppRepository
import com.hpcompose.ard.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository

    @Binds
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}