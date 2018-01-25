package com.reconnect.refuge.ui.cameracapture

import com.reconnect.refuge.ui.base.BaseView

/**
 * @author lusinabrian on 06/11/17.
 * @Notes CameraCaptureView
 */
interface CameraCaptureView : BaseView {

    fun setupViewListeners()

    fun capturePhoto()

    fun launchCamera()

    /**
     * Notify user of saved photo location
     * @param savedPhotoLocation
     * */
    fun notifyUserOfSavedImage(savedPhotoLocation: String?)

    /**
     * Displays permission rationale if the user denies permission
     * */
    fun displayPermissionRationale()

    fun processAndSetImage()

    /**
     * Clears views and image from View
     * @param isFileDeleted Whether the file was successfully deleted
     * */
    fun clearImage(isFileDeleted: Boolean)

    /**
     * Resamples the given picture given the photo path
     * @param photoPath
     * */
    fun resamplePic(photoPath: String)
}