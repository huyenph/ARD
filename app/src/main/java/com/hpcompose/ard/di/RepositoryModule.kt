package com.hpcompose.ard.di

import com.hpcompose.ard.data.datasource.AppDataSource
import com.hpcompose.ard.data.datasource.AuthDataSource
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
    abstract fun provideAppRepository(appDataSource: AppDataSource): AppRepository

    @Binds
    abstract fun provideAuthRepository(authDataSource: AuthDataSource): AuthRepository
}