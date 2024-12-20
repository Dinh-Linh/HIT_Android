package com.example.homework_week8.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_week8.database.Note
import com.example.homework_week8.databinding.ActivityAddNoteBinding
import com.example.homework_week8.database.NoteRoomDatabase
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
            addNote(
                note = Note(
                    title = bindingAddNote.getTiltle.text.toString(),
                    content = bindingAddNote.getContent.text.toString(),
                    like = false
                )
            )
            finish()
        }
    }

    fun addNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteRoomDatabase.noteDao().addNote(note)
            //println(noteRoomDatabase.noteDao().getAllNote())
        }
    }
}