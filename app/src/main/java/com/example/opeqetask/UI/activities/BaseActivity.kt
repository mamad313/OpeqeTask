package com.example.opeqetask.UI.activities

import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.opeqetask.R

internal const val NAME_TRANSFER = "NAME_TRANSFER"
internal const val USER_LOCATION = "USER_Location"
internal const val USER_EMAIL = "USER_EMAIL"
internal const val AVATAR_TRANSFER = "AVATAR_TRANSFER"

open class BaseActivity : AppCompatActivity() {
    private val TAG = "BaseActivity"

    internal fun activateToolbar(enableHome: Boolean) {
        Log.d(TAG, ".activateToolbar")
        var toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(enableHome)

    }
}