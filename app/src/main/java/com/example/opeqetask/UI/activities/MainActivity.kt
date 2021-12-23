package com.example.opeqetask.UI.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.opeqetask.R
import com.example.opeqetask.RecyclerOnItemClickListener
import com.example.opeqetask.UI.adapters.MainActivityAdapter
import com.example.opeqetask.viewmodel.ViewModelMain
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity(), RecyclerOnItemClickListener.OnRecyclerClickListener {

    private val viewUserModel: ViewModelMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.addOnItemTouchListener(RecyclerOnItemClickListener(this, recyclerView, this))

        viewUserModel.liveDataVar.observe(this, { user ->
            Log.d("Retrofit", "$user")
            recyclerView.adapter = MainActivityAdapter(user)
        })

    }

    override fun onItemClick(view: View, position: Int) {
        Log.d("onItemClick","onItemClick Clicked")
        viewUserModel.liveDataVar.observe(this, { user ->

            val intent = Intent(this, UserDetails::class.java)
            intent.putExtra(NAME_TRANSFER, user[position].name.first)
            intent.putExtra(AVATAR_TRANSFER, user[position].picture.large)
            intent.putExtra(USER_EMAIL, user[position].email)
            intent.putExtra(USER_LOCATION, user[position].location.city)

            startActivity(intent)

        })
    }

}