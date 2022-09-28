package com.upm.ard.data.local

import com.upm.ard.data.local.persistence.AppDao
import com.upm.ard.data.local.persistence.AppDatabase
import com.upm.ard.data.local.persistence.entity.UserEntity
import com.upm.ard.di.DatabaseModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@UninstallModules(DatabaseModule::class)
@HiltAndroidTest
class RoomDatabaseTest {
    @get: Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var database: AppDatabase

    @Inject
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
    fun insertItem() = runBlocking {
        val user = UserEntity(userName = "ARD")
        launch { dbDao.insertUser(user) }
//        advanceUntilIdle()
        assert(dbDao.getAllUser().contains(user))
//        assertEquals(user.userName, dbDao.getUserById(user.id).userName)
    }

    @Test
    fun deleteItem() = runTest {
        val user1 = UserEntity(userName = "ARD")
        val user2 = UserEntity(userName = "FRD")
        launch { dbDao.insertUser(user1) }
        launch { dbDao.insertUser(user2) }
        advanceUntilIdle()
//        launch { dbDao.deleteUserById(user1.id) }
//        assert(!dbDao.getAllUser().contains(user1))
        assertEquals(listOf(user1, user2), dbDao.getAllUser())
    }

    @Test
    fun deleteAllItem() = runTest(UnconfinedTestDispatcher()) {
        launch { dbDao.deleteAllUsers() }
//        advanceUntilIdle()
        assert(dbDao.getAllUser().isEmpty())
    }
}