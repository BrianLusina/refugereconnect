package com.reconnect.refuge.data.db.dao

import android.arch.persistence.room.*
import com.reconnect.refuge.data.db.entities.UserEntity
import io.reactivex.Flowable
import org.intellij.lang.annotations.Flow

/**
 * @author lusinabrian on 08/08/17.
 * @Notes Dao for [UserEntity]
 */
@Dao
interface UserDao {

    // CREATE
    @Insert
    fun insert(vararg userEntity: UserEntity): List<Long>

    // READ
    @Query("select * from user")
    fun getUsers(): Flowable<UserEntity>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): Flowable<List<UserEntity>>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Flowable<UserEntity>

    @Query("SELECT * FROM user WHERE refugee_id in (:refugeeIds)")
    fun loadAllByRefugeeIds(refugeeIds: IntArray) : Flowable<List<UserEntity>>

    // UPDATE
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(userEntity: UserEntity): Int

    // DELETE
    @Delete
    fun deleteUser(userEntity: UserEntity)
}