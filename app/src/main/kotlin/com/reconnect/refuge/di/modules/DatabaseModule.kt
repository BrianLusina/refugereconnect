package com.reconnect.refuge.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.reconnect.refuge.data.db.AppDatabase
import com.reconnect.refuge.data.db.DbHelper
import com.reconnect.refuge.data.db.DbHelperImpl
import com.reconnect.refuge.data.db.dao.UserDao
import com.reconnect.refuge.di.qualifiers.AppContextQualifier
import com.reconnect.refuge.di.qualifiers.DatabaseQualifier
import com.reconnect.refuge.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author lusinabrian on 23/01/18.
 * @Notes Database Module
 */
@Module
class DatabaseModule {

    @Provides
    @DatabaseQualifier
    fun provideDatabaseName(): String {
        return DATABASE_NAME
    }

    @Provides
    @Singleton
    fun provideDbHelper(dbHelper: DbHelperImpl) : DbHelper{
        return dbHelper
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@AppContextQualifier context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.getUserDao()
    }

}