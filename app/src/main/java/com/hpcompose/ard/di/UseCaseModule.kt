package com.hpcompose.ard.di

import com.hpcompose.ard.domain.repository.AppRepository
import com.hpcompose.ard.domain.repository.AuthRepository
import com.hpcompose.ard.domain.usecase.AppUseCase
import com.hpcompose.ard.domain.usecase.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAppUseCase(appRepository: AppRepository): AppUseCase = AppUseCase(appRepository)

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase =
        AuthUseCase(authRepository)
}