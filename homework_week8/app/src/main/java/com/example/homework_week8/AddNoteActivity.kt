package com.example.homework_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_week8.databinding.ActivityAddNoteBinding
import com.example.week8.NoteRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {
    private val bindingAddNote by lazy { ActivityAddNoteBinding.inflate(layoutInflater) }
    private val noteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingAddNote.root)

        bindingAddNote.back.setOnClickListener {
            finish()
        }

        bindingAddNote.saveNote.setOnClickListener {
            val note = Note(
                title = bindingAddNote.getTiltle.text.toString(),
                content = bindingAddNote.getContent.text.toString()
            )
            CoroutineScope(Dispatchers.IO).launch {
                noteRoomDatabase.noteDao().addNote(note)
//                println(noteRoomDatabase.noteDao().getAllNote())
            }
        }
    }
}