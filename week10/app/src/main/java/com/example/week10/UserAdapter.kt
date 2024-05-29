package com.example.week10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val onItemClick : (view : TextView) -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var userList = mutableListOf<User>()
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val address = itemView.findViewById<TextView>(R.id.address)
        val age = itemView.findViewById<TextView>(R.id.age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.name.text = userList[position].name
        holder.age.text = userList[position].age.toString()
        holder.address.text = userList[position].address
        holder.name.setOnClickListener{view ->
           // onItemClick.invoke()
            onItemClick(view as TextView)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setList(newList : MutableList<User>){
        userList = newList
        notifyDataSetChanged()
    }
}

