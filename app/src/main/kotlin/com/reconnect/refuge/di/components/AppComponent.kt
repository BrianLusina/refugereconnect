package com.reconnect.refuge.di.components

import android.app.Application
import android.content.Context
import com.reconnect.refuge.app.RefugeApp
import com.reconnect.refuge.data.DataManager
import com.reconnect.refuge.data.io.SchedulerProvider
import com.reconnect.refuge.di.modules.ApiModule
import com.reconnect.refuge.di.modules.AppModule
import com.reconnect.refuge.di.modules.DatabaseModule
import com.reconnect.refuge.di.qualifiers.AppContextQualifier
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * @author lusinabrian
 * @Notes App component
 */
@Singleton
@Component(modules = [(AppModule::class), ApiModule::class, DatabaseModule::class])
interface AppComponent {
    fun injectApp(refugeApp: RefugeApp)

    @AppContextQualifier
    fun context(): Context

    val getApplication: Application

    val dataManager: DataManager

    val schedulerProvider: SchedulerProvider

    val compositeDisposable : CompositeDisposable
}