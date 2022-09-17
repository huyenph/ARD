package com.upm.ard.di

import com.upm.ard.data.datasource.AuthDataSource
import com.upm.ard.domain.repository.AuthRepository
import com.upm.ard.domain.usecase.AuthUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideAuthRepository(authDataSource: AuthDataSource): AuthRepository
}