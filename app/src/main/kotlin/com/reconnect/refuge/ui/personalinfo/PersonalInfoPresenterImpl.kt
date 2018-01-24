package com.reconnect.refuge.ui.personalinfo

import com.reconnect.refuge.data.DataManager
import com.reconnect.refuge.data.io.SchedulerProvider
import com.reconnect.refuge.ui.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian
 * @Notes Main presenter implementation
 */
class PersonalInfoPresenterImpl<V : PersonalInfoView>
@Inject
constructor(val dataManager: DataManager, val schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable): PersonalInfoPresenter<V>, BasePresenterImpl<V>(dataManager, schedulerProvider, compositeDisposable){

    override fun onAttach(baseView: V) {
        super.onAttach(baseView)
        baseView.setUpListeners()
    }

    override fun onButtonNextClick(firstName: String, lastName: String, refugeeId: String, gender: String, phoneNumber: String) {
        // store the data locally
        //dataManager.storeUserData(firstName, lastName, refugeeId)
    }

}