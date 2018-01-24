package com.reconnect.refuge.ui.cameracapture

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.reconnect.refuge.R
import com.reconnect.refuge.ui.base.BaseActivity
import com.reconnect.refuge.utils.resamplePicUtil
import kotlinx.android.synthetic.main.activity_camera_capture.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class CameraCaptureActivity : BaseActivity(), CameraCaptureView, View.OnClickListener {

    //private var mTempPhotoPath: String? = null

    private var mResultsBitmap: Bitmap? = null

    private val requestImageCapture = 1
    private val requestStoragePermission = 1

    @Inject
    lateinit var cameraCapturePresenter: CameraCapturePresenter<CameraCaptureView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_capture)
        activityComponent.injectCameraCapture(this)

        cameraCapturePresenter.onAttach(this)
    }

    override fun setupViewListeners() {
        button_capture_photo.setOnClickListener(this)
        button_clear_photo.setOnClickListener(this)
        button_save.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button_capture_photo -> {
                cameraCapturePresenter.onCapturePhotoClicked()
            }

            button_clear_photo -> {
                cameraCapturePresenter.onClearBtnClicked()
            }

            button_save -> {
                cameraCapturePresenter.onSaveBtnClicked(mResultsBitmap)
            }
        }
    }

    /**
     * Launches the camera app.
     */
    override fun capturePhoto() {
        // Check for the external storage permission
        if (!hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            // If you do not have permission, request it
            requestPermissionsSafely(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), requestStoragePermission)
        } else {
            // Launch the camera if the permission exists
            launchCamera()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        // Called when you request permission to read and write to external storage
        when (requestCode) {
            requestStoragePermission -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    cameraCapturePresenter.onPermissionsGranted()
                } else {
                    cameraCapturePresenter.onPermissionDenied()
                }
            }
        }
    }

    override fun displayPermissionRationale() {
        // If you do not get permission, show a Toast
        toast(R.string.permission_denied)
    }

    /**
     * Creates a temporary image file and captures a picture to store in it.
     */
    override fun launchCamera() {
        // Create the capture image intent
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            val photoUri = cameraCapturePresenter.onTakePicture()

            if (photoUri != null) {
                // Add the URI so the camera can store the image
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)

                // Launch the camera activity
                startActivityForResult(takePictureIntent, requestImageCapture)
            } else {
                Toast.makeText(this, "Could not Launch camera", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // If the image capture activity was called and was successful
        when (resultCode) {
            Activity.RESULT_OK -> {
                if (requestCode == requestImageCapture) {
                    // Process the image and set it to the ImageView
                    cameraCapturePresenter.onActivityResultSuccess()
                }
            }

            Activity.RESULT_CANCELED -> {
                // Otherwise, delete the temporary image file
                cameraCapturePresenter.onActivityResultFailed()
            }
        }
    }

    /**
     * Method for processing the captured image and setting it to the TextView.
     */
    override fun processAndSetImage() {
        // Toggle Visibility of the views
        button_capture_photo.visibility = View.GONE
        title_text_view.visibility = View.GONE
        button_save.visibility = View.VISIBLE
        button_clear_photo.visibility = View.VISIBLE

        cameraCapturePresenter.onResamplePicRequest()
    }

    override fun resamplePic(photoPath: String) {
        // Resample the saved image to fit the ImageView
        mResultsBitmap = resamplePicUtil(this, photoPath)

        // Set the new bitmap to the ImageView
        image_view.setImageBitmap(mResultsBitmap)
    }

    override fun clearImage(isFileDeleted: Boolean) {
        // Clear the image and toggle the view visibility
        image_view.setImageResource(0)
        button_capture_photo.visibility = View.VISIBLE
        title_text_view.visibility = View.VISIBLE
        button_save.visibility = View.GONE
        button_clear_photo.visibility = View.GONE

        // If there is an error deleting the file, show a Toast
        if (!isFileDeleted) {
            toast(getString(R.string.error))
        }
    }

    override fun notifyUserOfSavedImage(savedPhotoLocation: String?) {
        if (savedPhotoLocation != null) {
            // Show a Toast with the save location
            Toast.makeText(this, getString(R.string.saved_message, savedPhotoLocation), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.not_saved), Toast.LENGTH_SHORT).show()
        }
    }
}
