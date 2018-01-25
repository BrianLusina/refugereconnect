package com.reconnect.refuge.services

import android.content.Intent
import android.os.IBinder
import com.reconnect.refuge.data.DataManager
import com.reconnect.refuge.utils.isNetworkAvailable
import javax.inject.Inject

/**
 * Sync Service responsible for syncing local data with server when an internet connection is established
 */
class SyncService : BaseService() {

    @Inject
    lateinit var dataManager : DataManager

    override fun onCreate() {
        super.onCreate()

        serviceComponent.injectSyncService(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if(isNetworkAvailable(this)){
            // if network is available, get the user data from the database
            dataManager.submitData()
        }

        // run until explicitly stopped
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }
}
