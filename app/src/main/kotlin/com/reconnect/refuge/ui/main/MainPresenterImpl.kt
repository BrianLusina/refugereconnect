package com.reconnect.refuge.ui.main

import android.graphics.Bitmap
import android.net.Uri
import com.reconnect.refuge.data.DataManager
import com.reconnect.refuge.data.io.SchedulerProvider
import com.reconnect.refuge.ui.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian
 * @Notes Main presenter implementation
 */
class MainPresenterImpl<V : MainView>
@Inject
constructor(val dataManager: DataManager, val schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable): MainPresenter<V>, BasePresenterImpl<V>(dataManager, schedulerProvider, compositeDisposable){

    override fun onAttach(baseView: V) {
        super.onAttach(baseView)

    }


}