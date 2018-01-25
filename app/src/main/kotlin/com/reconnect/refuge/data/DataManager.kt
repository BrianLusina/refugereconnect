package com.reconnect.refuge.data

import com.reconnect.refuge.data.db.DbHelper
import com.reconnect.refuge.data.file.FileHelper
import com.reconnect.refuge.data.prefs.SharedPrefsHelper

/**
 * @author lusinabrian
 * @Notes DataManager interface that will handle data/model layer of app
 */
interface DataManager : FileHelper, SharedPrefsHelper, DbHelper {

    fun submitData()
}