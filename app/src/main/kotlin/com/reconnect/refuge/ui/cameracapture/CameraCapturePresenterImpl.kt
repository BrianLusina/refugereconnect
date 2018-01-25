package com.emojify.me.ui.main

import android.graphics.Bitmap
import android.net.Uri
import com.reconnect.refuge.data.DataManager
import com.reconnect.refuge.data.io.SchedulerProvider
import com.reconnect.refuge.ui.base.BasePresenterImpl
import com.reconnect.refuge.ui.cameracapture.CameraCapturePresenter
import com.reconnect.refuge.ui.cameracapture.CameraCaptureView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian on 06/11/17.
 * @Notes Main presenter implementation
 */
class CameraCapturePresenterImpl<V : CameraCaptureView>
@Inject
constructor(val dataManager: DataManager, val schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable): CameraCapturePresenter<V>, BasePresenterImpl<V>(dataManager, schedulerProvider, compositeDisposable){

    // fixme: make key unique
    private val sharedPrefsKey = "emojifyme"

    override fun onAttach(baseView: V) {
        super.onAttach(baseView)
        baseView.setupViewListeners()
    }

    override fun onCapturePhotoClicked() {
        baseView.capturePhoto()
    }

    override fun onClearBtnClicked() {
        val photoPath = dataManager.getImageFilePath(sharedPrefsKey)
        val isFileDeleted = dataManager.deleteImageFile(photoPath)
        baseView.clearImage(isFileDeleted)
    }

    override fun onSaveBtnClicked(bitmap: Bitmap?) {
        val photoPath = dataManager.getImageFilePath(sharedPrefsKey)

        dataManager.deleteImageFile(photoPath)

        val savedImagePath = dataManager.saveImageFile(bitmap)

        baseView.notifyUserOfSavedImage(savedImagePath)
    }

    override fun onPermissionDenied() {
        baseView.displayPermissionRationale()
    }

    override fun onPermissionsGranted() {
        baseView.launchCamera()
    }

    override fun onResamplePicRequest() {
        val photoPath = dataManager.getImageFilePath(sharedPrefsKey)
        baseView.resamplePic(photoPath)
    }

    override fun onActivityResultFailed() {
        val photoPath = dataManager.getImageFilePath(sharedPrefsKey)
        dataManager.deleteImageFile(photoPath)
    }

    override fun onActivityResultSuccess() {
        baseView.processAndSetImage()
    }

    override fun onTakePicture() : Uri?{
        val (tempImageFile, photoUri)= dataManager.createTempImageFile()
        tempImageFile?.absolutePath?.let { dataManager.saveImageFilePath(sharedPrefsKey, it) }
        return photoUri
    }
}