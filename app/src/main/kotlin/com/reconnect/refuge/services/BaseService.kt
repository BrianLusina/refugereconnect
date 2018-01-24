package com.reconnect.refuge.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.reconnect.refuge.di.components.DaggerServiceComponent
import com.reconnect.refuge.di.components.ServiceComponent
import com.reconnect.refuge.di.modules.ServiceModule

/**
 * @author lusinabrian
 * @Notes Base service for application, this will define rules common to all services running in
 * application
 */
abstract class BaseService : Service() {

    val serviceComponent: ServiceComponent by lazy {
        DaggerServiceComponent.builder()
                .serviceModule(ServiceModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

    }

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }
}