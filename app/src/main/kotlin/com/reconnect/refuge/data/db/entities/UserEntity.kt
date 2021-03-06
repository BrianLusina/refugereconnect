package com.reconnect.refuge.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author lusinabrian on 23/01/18.
 * @Notes A single User Entity
 */
@Entity(tableName = "user")
data class UserEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "first_name")
        var first_name: String,

        @ColumnInfo(name = "last_name")
        var last_name : String,

        @ColumnInfo(name = "refugee_id")
        var refugeeId: String,

        @ColumnInfo(name = "gender")
        var gender: String,

        @ColumnInfo(name = "created_at")
        var createdAt: String,

        @ColumnInfo(name = "updated_at")
        var updatedAt: String,

        @ColumnInfo(name = "photo_path")
        var photoPath: String
)
