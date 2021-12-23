package com.example.opeqetask.UI.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.opeqetask.R
import com.example.opeqetask.models.Results
import com.squareup.picasso.Picasso

class ViewHolderAdapter(view: View) :RecyclerView.ViewHolder(view){
    val avatar : ImageView = view.findViewById(R.id.Avatar)
    val name : TextView = view.findViewById(R.id.Name_tv)
    val email : TextView = view.findViewById(R.id.Email_tv)
}

class MainActivityAdapter(private val userList:List<Results>):RecyclerView.Adapter<ViewHolderAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolderAdapter(view)
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        holder.name.text = userList[holder.adapterPosition].name.first
        holder.email.text = userList[holder.adapterPosition].email
        Picasso.get().load(userList[holder.adapterPosition].picture.large)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder).into(holder.avatar)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}
