package com.reconnect.refuge.ui.base

/**
 * @author lusinabrian
 * @Notes BasePresenter from which all presenters will inherit from
 */
interface BasePresenter<V : BaseView> {

    fun onAttach(baseView : V)

    fun onDetach()
}