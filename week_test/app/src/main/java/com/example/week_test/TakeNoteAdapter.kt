package com.example.week_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TakeNoteAdapter(val listTakeNote : MutableList<TakeNote>) : RecyclerView.Adapter<TakeNoteAdapter.TakeNoteViewHolder>(){

    class TakeNoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tiltle = itemView.findViewById<TextView>(R.id.tiltle)
        val content = itemView.findViewById<TextView>(R.id.content)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TakeNoteAdapter.TakeNoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_take_note, parent, false)
        return TakeNoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: TakeNoteAdapter.TakeNoteViewHolder, position: Int) {
        holder.tiltle.text = listTakeNote[position].title
        holder.content.text = listTakeNote[position].content
    }

    override fun getItemCount(): Int = listTakeNote.size

}