package com.example.homework_week8

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week8.NoteRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteAdapter(var listNote: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    class NoteViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val content = itemView.findViewById<TextView>(R.id.content)
        val favourite = itemView.findViewById<ImageView>(R.id.isFavourite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_take_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = listNote.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.title.text = listNote[position].title
        holder.content.text = listNote[position].content
        holder.favourite.setOnClickListener {
            val clickedNote = listNote[position]
            val noteRoomDatabase = NoteRoomDatabase.getDatabase(holder.itemView.context)
            holder.favourite.setImageResource(R.color.red)
            val noteDao = noteRoomDatabase.noteDao()
            CoroutineScope(Dispatchers.IO).launch {
                // Thực hiện cập nhật trạng thái yêu thích của ghi chú
                clickedNote.like = !clickedNote.like
                noteDao.getAllNote().observeForever { updateNote ->
                    setData(updateNote)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(note: List<Note>) {
        this.listNote = note
        notifyDataSetChanged()
    }
}