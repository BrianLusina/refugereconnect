package com.reconnect.refuge.ui.cameracapture

import android.graphics.Bitmap
import android.net.Uri
import com.reconnect.refuge.ui.base.BasePresenter

/**
 * @author lusinabrian on 06/11/17.
 * @Notes Main Presenter
 */
interface CameraCapturePresenter<V : CameraCaptureView> : BasePresenter<V> {

    fun onCapturePhotoClicked()

    fun onClearBtnClicked()

    /**
     * Saves the given image
     * */
    fun onSaveBtnClicked(bitmap: Bitmap?)

    fun onPermissionsGranted()

    fun onPermissionDenied()

    fun onTakePicture() : Uri?

    /**
     * On Activity result success
     * */
    fun onActivityResultSuccess()

    /**
     * On Activity result failed
     * */
    fun onActivityResultFailed()

    /**
     * Request to resample picture
     * */
    fun onResamplePicRequest()
}