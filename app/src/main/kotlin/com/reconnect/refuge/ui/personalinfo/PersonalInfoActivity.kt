package com.reconnect.refuge.ui.personalinfo

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.reconnect.refuge.R
import com.reconnect.refuge.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_personal_info.*
import org.jetbrains.anko.find
import javax.inject.Inject

/**
 * Main entry of application
 * This will simply be used to collect personal information from the Refugee
 * First name, last name and refugee id, when all these are valid, we store them locally.
 * This information will be used in the summary screen, where they will be allowed to edit the
 * information as need be.
 * */
class PersonalInfoActivity : BaseActivity(), PersonalInfoView, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    @Inject
    lateinit var personalInfoPresenter: PersonalInfoPresenter<PersonalInfoView>

    var genderSelected = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        activityComponent.injectPersonalInfo(this)

        personalInfoPresenter.onAttach(this)
    }

    override fun setUpListeners() {
        button_next.setOnClickListener(this)
        radio_group_gender.setOnCheckedChangeListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button_next -> {
                // verify user information, first name, last name and id
                val firstName = text_input_edit_text_first_name.text.toString()
                val lastName = text_input_edit_text_last_name.text.toString()
                val refugeeId = text_input_edit_text_refugee_id.text.toString()
                var formValid = true

                // First name
                if(TextUtils.isEmpty(firstName)){
                    text_input_edit_text_first_name.error = getString(R.string.error_msg_first_name_text)
                    formValid = false
                }

                // Last name
                if(TextUtils.isEmpty(lastName)){
                    text_input_edit_text_last_name.error = getString(R.string.error_msg_last_name_text)
                    formValid = false
                }

                // Refugee Id
                if(TextUtils.isEmpty(refugeeId)){
                    text_input_edit_text_refugee_id.error = getString(R.string.error_msg_refugee_id)
                    formValid = false
                }

                // if the form is valid we call to store the data locally first
                if(formValid){
                    personalInfoPresenter.onButtonNextClick(firstName, lastName, refugeeId, genderSelected)
                }
            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val radioBtn = find<RadioButton>(checkedId)
        genderSelected = radioBtn.text.toString()
    }

    override fun proceedToCameraCapture() {
        //startActivity<>()
    }

}
