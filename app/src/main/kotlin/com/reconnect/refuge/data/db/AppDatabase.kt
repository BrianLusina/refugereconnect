package com.reconnect.refuge.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.reconnect.refuge.data.db.dao.UserDao
import com.reconnect.refuge.data.db.entities.UserEntity

/**
 * @author lusinabrian on 23/01/18.
 * @Notes Room Database
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract  class AppDatabase : RoomDatabase(){

    abstract fun getUserDao(): UserDao

}