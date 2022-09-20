package com.upm.ard.data.local

import android.content.Context
import androidx.room.Room
import com.upm.ard.common.extensions.DB_NAME
import com.upm.ard.data.local.persistence.AppDao
import com.upm.ard.data.local.persistence.AppDatabase
import com.upm.ard.data.local.persistence.entity.UserEntity
import com.upm.ard.di.DatabaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@OptIn(ExperimentalCoroutinesApi::class)
@UninstallModules(DatabaseModule::class)
@HiltAndroidTest
class RoomDatabaseTest {
    @get: Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
//    @Named("test_db")
    lateinit var database: AppDatabase

    @Inject
//    @Named("test_dao")
    lateinit var dbDao: AppDao

    @Before
    fun init() {
        hiltRule.inject()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertItem() = runTest {
        val user = UserEntity(userName = "Huyen")
        launch { dbDao.insertUser(user) }
//        val users = launch { dbDao.getAllUser() }
//        assert(users.contains(user))
        advanceUntilIdle()
        assertEquals(user.userName, dbDao.getUserById(user.id).userName)
    }
//    {
//        val user = UserEntity(userName = "Huyen")
//        dbDao.insertUser(user)
////        val users = dbDao.getAllUser()
////        assert(users.contains(user))
//    }

    @Module
    @InstallIn(SingletonComponent::class)
    object TestDatabaseModule {
        @Provides
        @Singleton
//        @Named("test_db")
        fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .build()

        @Provides
        @Singleton
//        @Named("test_dao")
        fun provideDBDao(database: AppDatabase): AppDao = database.appDao()
    }
}