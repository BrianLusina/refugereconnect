package com.reconnect.refuge.ui.main

import android.os.Bundle
import android.view.View
import com.reconnect.refuge.R
import com.reconnect.refuge.ui.base.BaseActivity
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView, View.OnClickListener {

    @Inject
    lateinit var mainPresenter: MainPresenter<MainView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.injectMain(this)

        mainPresenter.onAttach(this)
    }


    override fun onClick(v: View?) {
        when (v) {
        }
    }
}
