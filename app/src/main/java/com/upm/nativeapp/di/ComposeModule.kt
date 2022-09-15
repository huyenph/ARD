package com.upm.nativeapp.di

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

//@OptIn(ExperimentalAnimationApi::class)
//@Module
//@InstallIn(SingletonComponent::class)
//object ComposeModule {
//    @Provides
//    @Composable
//    fun provideAppNavController() = rememberAnimatedNavController()
//}