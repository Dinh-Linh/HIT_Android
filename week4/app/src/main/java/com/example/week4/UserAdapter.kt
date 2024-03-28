package com.example.week4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val userList: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUsername = itemView.findViewById<TextView>(R.id.name)
        val textViewAddress = itemView.findViewById<TextView>(R.id.address)
        val img = itemView.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.textViewUsername.text = userList[position].username
        holder.textViewAddress.text = userList[position].adress

        holder.textViewUsername.setOnClickListener {
            Toast.makeText(
                holder.textViewUsername.context,
                "${userList[position]}",
                Toast.LENGTH_LONG
            ).show()
        }
        holder.textViewAddress.setOnClickListener {
            userList.removeAt(position)
            notifyDataSetChanged()
        }

        holder.img.setImageResource(userList[position].image)
    }
}