package com.upm.ard.di

import android.content.Context
import androidx.room.Room
import com.upm.ard.common.extensions.DB_NAME
import com.upm.ard.data.local.persistence.AppDao
import com.upm.ard.data.local.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

