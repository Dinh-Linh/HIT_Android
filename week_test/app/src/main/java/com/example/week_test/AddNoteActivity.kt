package com.example.week_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.week_test.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
    private lateinit var bindingAddNote: ActivityAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAddNote = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(bindingAddNote.root)
        bindingAddNote.back.setOnClickListener {
            val intent = Intent(this, TakeNoteActivity::class.java)
            startActivity(intent)
        }

        bindingAddNote.addNote.setOnClickListener {
            val tiltle = bindingAddNote.getTiltle.text.toString()
            val content = bindingAddNote.getContent.text.toString()
            navigateToTakeNote(tiltle, content)
        }

    }


    private fun navigateToTakeNote(tiltle: String, content: String) {
        val intent = Intent(this, TakeNoteActivity::class.java)
        intent.putExtra("tiltle", tiltle)
        intent.putExtra("content", content)
        startActivity(intent)
    }


}

