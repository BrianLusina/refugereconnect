package com.reconnect.refuge.ui.summary

import com.reconnect.refuge.ui.base.BaseView

/**
 * @author lusinabrian on 25/01/18.
 * @Notes View interface
 */
interface SummaryView : BaseView{

    fun setUpListeners()

    fun populateFormData(firstName : String, lastName : String, refugeeId : String, gender : String)
}