package com.example.homework_week8

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_week8.database.Note
import com.example.homework_week8.database.NoteRoomDatabase
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
            val noteRoomDatabase = NoteRoomDatabase.getDatabase(it.context)
            clickedNote.like = !clickedNote.like
            //holder.favourite.setImageResource(R.drawable.heart_red)
            if (listNote[position].like){
                holder.favourite.setImageResource(R.drawable.heart_red)
            }
            else{
                holder.favourite.setImageResource(R.drawable.heart)
            }
            val noteDao = noteRoomDatabase.noteDao()
            CoroutineScope(Dispatchers.IO).launch {
                noteRoomDatabase.noteDao().updateNote(
                    Note(
                        id = null,
                        title = listNote[position].title,
                        content = listNote[position].content,
                        like = listNote[position].like
                    )
                )
            }
            noteDao.getAllNote().observeForever { updateNote ->
                setData(updateNote)
            }
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(note: List<Note>) {
        this.listNote = note
        notifyDataSetChanged()
    }

}