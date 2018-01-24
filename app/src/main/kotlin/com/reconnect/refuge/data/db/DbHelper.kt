package com.reconnect.refuge.data.db

/**
 * @author lusinabrian on 24/01/18.
 * @Notes Db Helper interface that will be used by Data manager to delegate tasks to the data store
 * implementation, whichever it may be, in this case, it is Room.
 */
interface DbHelper {

    /**
     * Store user data in database given the following values
     * @param firstName First name of user
     * @param lastName Last namr of user
     * @param refugeeId Refugee Id
     * @param gender Gender of the given Refugee
     * */
    fun storeUserData(firstName: String, lastName: String, refugeeId: String, gender: String)
}