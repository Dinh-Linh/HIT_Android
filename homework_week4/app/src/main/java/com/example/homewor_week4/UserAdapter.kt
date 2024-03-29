package com.example.homewor_week4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val userList: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUsername = itemView.findViewById<TextView>(R.id.name)
        val textViewAddress = itemView.findViewById<TextView>(R.id.address)
        val img = itemView.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemuser, parent, false)
        return UserViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.textViewUsername.text = userList[position].name
        holder.textViewAddress.text = userList[position].address
        holder.img.setImageResource(userList[position].image)

    }

    override fun getItemCount(): Int = userList.size
}