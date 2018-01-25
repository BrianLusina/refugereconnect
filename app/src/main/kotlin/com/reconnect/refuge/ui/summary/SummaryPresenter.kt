package com.reconnect.refuge.ui.summary

import com.reconnect.refuge.ui.base.BasePresenter

/**
 * @author lusinabrian on 25/01/18.
 * @Notes Presenter interface
 */
interface SummaryPresenter<V : SummaryView> : BasePresenter<V>{

    fun onResume()

    fun onSubmit()
}