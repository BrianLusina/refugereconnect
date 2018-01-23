package com.reconnect.refuge.services

import android.content.Intent
import android.os.IBinder

/**
 * Sync Service responsible for syncing local data with server when an internet connection is established
 */
class SyncService : BaseService() {

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }
}
