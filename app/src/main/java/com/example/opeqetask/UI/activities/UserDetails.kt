package com.example.opeqetask.UI.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.opeqetask.R
import com.example.opeqetask.models.Results
import com.example.opeqetask.models.UserResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_details.*


class UserDetails : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        activateToolbar(false)

        val name = intent.getSerializableExtra(NAME_TRANSFER)
        val avatar = intent.getSerializableExtra(AVATAR_TRANSFER)
        val email = intent.getSerializableExtra(USER_EMAIL)
        val location = intent.getSerializableExtra(USER_LOCATION)

        nameTv.text = name.toString()
        emailTv.text = email.toString()
        locationTv.text= location.toString()

        Picasso.get().load(avatar.toString())
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder).into(avatarView)
    }

}