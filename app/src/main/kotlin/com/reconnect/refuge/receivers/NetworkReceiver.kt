package com.reconnect.refuge.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.reconnect.refuge.services.SyncService
import com.reconnect.refuge.utils.isNetworkAvailable
import com.reconnect.refuge.utils.isWifiEnabled
import org.jetbrains.anko.startService

/**
 * Checks if the user has changed their network connection or if they are connected to
 * a Network
 */
class NetworkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            "android.net.conn.CONNECTIVITY_CHANGE" -> {
                // check which connection device is on
                if (isNetworkAvailable(context)) {
                    // if wifi is enabled,
                    if (isWifiEnabled(context)) {
                        // sync data
                        context.startService<SyncService>()
                    }
//                    } else if (isMobileDataEnabled(context)) {
//                        // we are in a mobile data connection, notify the user they have changed connection
//                        // to a mobile connection
//
//                    }
                } else if (!isNetworkAvailable(context)) {

                    // we are offline we should notify the user of the disconnection
                    ///MainPresenterImpl.updateDeviceNetworkStatus(false)
                }
            }
        }
    }

}

