package com.hpcompose.ard.data.local.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.hpcompose.ard.common.extensions.APP_CONFIG_TABLE
import java.util.*

@Entity(tableName = APP_CONFIG_TABLE)
data class ConfigEntity(
    @ColumnInfo(name = "user_id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "username")
    val userName: String
)