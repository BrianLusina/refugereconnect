package com.reconnect.refuge.ui.base

import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.reconnect.refuge.app.RefugeApp
import com.reconnect.refuge.di.components.ActivityComponent
import com.reconnect.refuge.di.components.DaggerActivityComponent
import com.reconnect.refuge.di.modules.ActivityModule

/**
 * @author lusinabrian
 * @Notes Base Activity
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    val activityComponent : ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .appComponent((application as RefugeApp).appComponent)
                .activityModule(ActivityModule(this))
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }


}