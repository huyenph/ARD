package com.upm.nativeapp.data.local.persistence

import androidx.room.*
import com.upm.nativeapp.common.extensions.USER_TABLE_NAME
import com.upm.nativeapp.data.local.persistence.entity.UserEntity

@Dao
interface AppDao {
    @Query("SELECT * FROM $USER_TABLE_NAME WHERE user_id = :id")
    suspend fun getUserById(id: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("DELETE FROM $USER_TABLE_NAME WHERE user_id = :id")
    suspend fun deleteUserById(id: String)

    @Query("DELETE FROM $USER_TABLE_NAME")
    suspend fun deleteAllUsers()
}