package com.example.week9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StudentAdapter(val list: List<Student>) : Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(itemView: View) : ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val age = itemView.findViewById<TextView>(R.id.age)
        val address = itemView.findViewById<TextView>(R.id.address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.age.text = list[position].age.toString()
        holder.address.text = list[position].address

    }

    override fun getItemCount(): Int = list.size

}