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

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "email")
        var email: String,

        @ColumnInfo(name = "phone_number")
        var phoneNumber: String,

        @ColumnInfo(name = "gender")
        var gender: String,

        @ColumnInfo(name = "created_at")
        var createdAt: String,

        @ColumnInfo(name = "updated_at")
        var updatedAt: String,

        @ColumnInfo(name = "profile_path")
        var profilePath: String
)
