package com.hpcompose.ard.data.datasource.local.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hpcompose.ard.data.datasource.local.persistence.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): UserDao
}