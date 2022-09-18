package com.upm.ard.di

import com.upm.ard.domain.repository.AuthRepository
import com.upm.ard.domain.usecase.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase =
        AuthUseCase(authRepository)
}