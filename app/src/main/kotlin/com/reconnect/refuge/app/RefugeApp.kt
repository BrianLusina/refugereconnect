package com.reconnect.refuge.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import android.support.v7.app.AppCompatDelegate
import com.reconnect.refuge.di.components.AppComponent
import com.reconnect.refuge.di.modules.AppModule

/**
 * @author lusinabrian
 * @Notes Application singleton
 */
class RefugeApp : Application(){
    val appComponent : AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.injectApp(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}