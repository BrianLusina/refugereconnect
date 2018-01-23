package com.reconnect.refuge.di.modules

import android.app.Service
import dagger.Module

/**
 * @author lusinabrian
 * @Notes Base Service Module that will provide dependencies to application
 */
@Module
class ServiceModule(private val mService: Service)