package com.reconnect.refuge.di.modules

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.reconnect.refuge.di.scopes.ActivityScope
import com.reconnect.refuge.ui.personalinfo.PersonalInfoPresenter
import com.reconnect.refuge.ui.personalinfo.PersonalInfoPresenterImpl
import com.reconnect.refuge.ui.personalinfo.PersonalInfoView
import dagger.Module
import dagger.Provides

/**
 * @author lusinabrian
 * @Notes Activity Module
 */
@Module
class ActivityModule (private val mActivity: AppCompatActivity){

    @Provides
    @ActivityScope
    fun provideContext(): Context {
        return mActivity
    }

    @Provides
    fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    @ActivityScope
    fun provideMainPresenter(personalInfoPresenter: PersonalInfoPresenterImpl<PersonalInfoView>): PersonalInfoPresenter<PersonalInfoView> {
        return personalInfoPresenter
    }
}