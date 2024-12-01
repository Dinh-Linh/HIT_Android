package com.example.week12_mvvm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week12_mvvm.R
import com.example.week12_mvvm.data.data_class.Note

class NoteAdapter(private val onClickItem: (Note) -> Unit = {}) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var listNote = mutableListOf<Note>()
    var onClick: ((Note) -> Unit)? = null

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val content: TextView = itemView.findViewById(R.id.content)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_take_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = listNote.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        with(holder) {
            title.text = listNote[position].title
            content.text = listNote[position].content
            date.text = listNote[position].date.toString()
            itemView.setOnClickListener {
                onClickItem(listNote[position])
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(note: MutableList<Note>) {
        this.listNote = note
        notifyDataSetChanged()
    }

}