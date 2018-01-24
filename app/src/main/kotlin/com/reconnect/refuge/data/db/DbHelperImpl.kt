package com.reconnect.refuge.data.db

import com.reconnect.refuge.data.db.dao.UserDao
import com.reconnect.refuge.data.db.entities.UserEntity
import com.reconnect.refuge.utils.TIMESTAMP_FORMAT
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 24/01/18.
 * @Notes Implementation of Db Helper, This will interact with the chose data store, In this case
 * the use of Room DAO to access SQlite over an abstraction layer
 */
@Singleton
class DbHelperImpl @Inject constructor(
        val userDao: UserDao
) : DbHelper {

    override fun storeUserData(firstName: String, lastName: String, refugeeId: String, gender: String) {
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        val simpleDateFormat = SimpleDateFormat(TIMESTAMP_FORMAT, Locale.getDefault())
        val formattedDate = simpleDateFormat.format(calendar.time)

        val userEntity = UserEntity(0, firstName, lastName, refugeeId, gender, formattedDate, "", "")
        userDao.insertUser(userEntity)
    }
}