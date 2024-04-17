package com.example.week_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week_test.databinding.ActivityTakeNoteBinding

class TakeNoteActivity : AppCompatActivity() {
    private lateinit var bindingTakeNote: ActivityTakeNoteBinding
    private lateinit var tiltle: String
    private lateinit var content: String
    private val list = DataTakeNote.takeNoteList
    private lateinit var takeNoteAdapter : TakeNoteAdapter
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingTakeNote = ActivityTakeNoteBinding.inflate(layoutInflater)
        setContentView(bindingTakeNote.root)

        tiltle = intent.getStringExtra("tiltle").toString() ?: ""
        content = intent.getStringExtra("content").toString() ?: ""

        takeNoteAdapter = TakeNoteAdapter(list)
        bindingTakeNote.addNote.setOnClickListener{
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
        bindingTakeNote.recycleViewTakeNote.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bindingTakeNote.recycleViewTakeNote.adapter = takeNoteAdapter
        addTakeNoteToList(tiltle, content)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addTakeNoteToList(tiltle: String, content: String) {

        // Kiểm tra tiltle và content có giá trị hay không trước khi thêm vào danh sách
        if (tiltle.isNotEmpty() && content.isNotEmpty()) {
            val newTakeNote = TakeNote(tiltle, content)

            if (DataTakeNote.takeNoteList.isEmpty()) {
                DataTakeNote.takeNoteList = mutableListOf()
            }

            DataTakeNote.takeNoteList.add(newTakeNote)

            // Cập nhật adapter khi thêm mục mới
            takeNoteAdapter.notifyDataSetChanged()

            // Hiển thị RecyclerView nếu danh sách không trống
            bindingTakeNote.recycleViewTakeNote.isVisible = true
        }
    }


}