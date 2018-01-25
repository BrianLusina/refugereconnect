package com.reconnect.refuge.ui.summary

import android.os.Bundle
import android.view.View
import com.reconnect.refuge.R
import com.reconnect.refuge.ui.base.BaseActivity
import com.reconnect.refuge.utils.isNetworkAvailable
import kotlinx.android.synthetic.main.activity_summary.*
import javax.inject.Inject

/**
 * @author lusinabrian on 25/01/18.
 * @Notes Summary Activity, displaying the summary of details from the database
 */
class SummaryActivity : BaseActivity(), SummaryView, View.OnClickListener {

    @Inject
    lateinit var summaryPresenter: SummaryPresenter<SummaryView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        activityComponent.injectSummary(this)

        summaryPresenter.onAttach(this)
    }

    override fun onResume() {
        super.onResume()
        summaryPresenter.onResume()
    }

    override fun setUpListeners() {
        button_submit.setOnClickListener(this)
        button_cancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button_submit -> {
                if(isNetworkAvailable(this)){
                    summaryPresenter.onSubmit()
                } else{
                    // network error, will post data later

                }
            }

            button_cancel -> {

            }
        }
    }

    override fun populateFormData(firstName: String, lastName: String, refugeeId: String, gender: String) {
        text_input_edit_text_first_name.setText(firstName)
        text_input_edit_text_last_name.setText(lastName)
        text_input_edit_text_refugee_id.setText(refugeeId)

        if (gender.toLowerCase() == "male") {
            radio_button_gender_male.isChecked = true
        } else {
            radio_button_gender_female.isChecked = true
        }
    }
}