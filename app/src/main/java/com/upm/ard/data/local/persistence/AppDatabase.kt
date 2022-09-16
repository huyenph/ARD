package com.upm.ard.data.local.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.upm.ard.data.local.persistence.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}