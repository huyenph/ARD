package com.upm.nativeapp.data.local.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.upm.nativeapp.common.extensions.USER_TABLE_NAME
import java.util.*

@Entity(tableName = USER_TABLE_NAME)
data class UserEntity(
    @PrimaryKey @ColumnInfo(name = "user_id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "username")
    val userName: String
)