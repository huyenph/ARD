package com.upm.ard.data.local.persistence

import androidx.room.*
import com.upm.ard.common.extensions.USER_TABLE_NAME
import com.upm.ard.data.local.persistence.entity.UserEntity

@Dao
interface AppDao {
    @Query("SELECT * FROM $USER_TABLE_NAME")
     fun getAllUser(): List<UserEntity>

    @Query("SELECT * FROM $USER_TABLE_NAME WHERE user_id = :id")
    suspend fun getUserById(id: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertUser(userEntity: UserEntity)

    @Query("DELETE FROM $USER_TABLE_NAME WHERE user_id = :id")
    suspend fun deleteUserById(id: String)

    @Query("DELETE FROM $USER_TABLE_NAME")
    suspend fun deleteAllUsers()
}