package com.reconnect.refuge.ui.summary

import com.reconnect.refuge.data.DataManager
import com.reconnect.refuge.data.io.SchedulerProvider
import com.reconnect.refuge.ui.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian on 25/01/18.
 * @Notes Presenter implementation
 */
class SummaryPresenterImpl<V : SummaryView> @Inject constructor(val dataManager: DataManager, val schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenterImpl<V>(dataManager, schedulerProvider, compositeDisposable), SummaryPresenter<V> {

    override fun onAttach(baseView: V) {
        super.onAttach(baseView)
        baseView.setUpListeners()
    }

    override fun onResume() {
        // pick data from data store
        dataManager.getUserEntity()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.newThread())
                .subscribe({
                    baseView.populateFormData(it.first_name, it.last_name, it.refugeeId, it.gender)
                }, {
                    // error

                })
    }

    override fun onSubmit() {
        // submit data to server
        dataManager.submitData()
    }
}