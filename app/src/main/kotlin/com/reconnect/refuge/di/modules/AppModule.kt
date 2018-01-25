package com.reconnect.refuge.di.modules

import android.app.Application
import android.content.Context
import com.reconnect.refuge.data.DataManager
import com.reconnect.refuge.data.DataManagerImpl
import com.reconnect.refuge.data.file.FileHelper
import com.reconnect.refuge.data.file.FileHelperImpl
import com.reconnect.refuge.data.io.SchedulerProvider
import com.reconnect.refuge.data.io.SchedulerProviderImpl
import com.reconnect.refuge.data.prefs.SharedPrefsHelper
import com.reconnect.refuge.data.prefs.SharedPrefsHelperImpl
import com.reconnect.refuge.di.qualifiers.AppContextQualifier
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author lusinabrian
 * @Notes Application Module
 */
@Module
class AppModule(val mApplication: Application) {

    @Provides
    @AppContextQualifier
    fun provideContext(): Context {
        return mApplication
    }

    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Named("refugePrefsName")
    fun provideSharedPrefsName(): String{
        return "refugePrefs"
    }


    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    fun provideSchedulers(): SchedulerProvider {
        return SchedulerProviderImpl()
    }

    @Provides
    @Singleton
    fun provideDataManager(dataManager: DataManagerImpl): DataManager {
        return dataManager
    }

    @Provides
    @Singleton
    fun provideFileHelper(fileHelper: FileHelperImpl): FileHelper {
        return fileHelper
    }

    @Provides
    @Singleton
    fun providePrefsHelper(sharedPrefsHelper: SharedPrefsHelperImpl): SharedPrefsHelper {
        return sharedPrefsHelper
    }
}