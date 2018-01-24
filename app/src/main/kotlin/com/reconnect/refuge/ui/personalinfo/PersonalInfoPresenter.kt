package com.reconnect.refuge.ui.personalinfo

import com.reconnect.refuge.ui.base.BasePresenter

/**
 * @author lusinabrian on 06/11/17.
 * @Notes Main Presenter
 */
interface PersonalInfoPresenter<V : PersonalInfoView> : BasePresenter<V> {

    /**
     * Callback for next button click event. This will trigger the storage of data to a local data
     * store, after which we can proceed to the next step of the data capture process
     * @param firstName User's First name
     * @param lastName User's Last name
     * @param refugeeId User's refugee Id
     * @param gender User's gender
     * @param phoneNumber User's phone number
     * */
    fun onButtonNextClick(firstName : String, lastName : String, refugeeId : String, gender : String, phoneNumber: String)

}