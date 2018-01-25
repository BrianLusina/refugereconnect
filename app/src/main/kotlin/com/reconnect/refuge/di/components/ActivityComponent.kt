package com.reconnect.refuge.di.components

import com.reconnect.refuge.di.modules.ActivityModule
import com.reconnect.refuge.di.scopes.ActivityScope
import com.reconnect.refuge.ui.cameracapture.CameraCaptureActivity
import com.reconnect.refuge.ui.personalinfo.PersonalInfoActivity
import com.reconnect.refuge.ui.summary.SummaryActivity
import dagger.Component

/**
 * @author lusinabrian
 * @Notes connector between modules and injected classes
 */
@ActivityScope
@Component(modules = [(ActivityModule::class)], dependencies = [(AppComponent::class)])
interface ActivityComponent {

    fun injectPersonalInfo(personalInfoActivity: PersonalInfoActivity)

    fun injectCameraCapture(cameraCaptureActivity: CameraCaptureActivity)

    fun injectSummary(summaryActivity : SummaryActivity)
}