package com.example.week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week8.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val noteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addNote.setOnClickListener {
            val note = Note(
                title = binding.title.text.toString(),
                content = binding.content.text.toString(),
                date = binding.date.text.toString()
            )

            // Bất đồng bộ. Không chạy được trực tiếp trên main -> Tạo 1 nhánh mới de chay code
            CoroutineScope(Dispatchers.IO).launch {
                noteRoomDatabase.noteDao().addNode(note)
            }
        }
        binding.showNote.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                println(noteRoomDatabase.noteDao().getAllNote())
            }
        }
    }
}