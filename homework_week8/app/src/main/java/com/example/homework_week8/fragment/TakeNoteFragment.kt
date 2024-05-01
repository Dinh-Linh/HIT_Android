package com.example.homework_week8.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_week8.NoteAdapter
import com.example.homework_week8.databinding.FragmentTakeNoteBinding
import com.example.homework_week8.database.NoteRoomDatabase
import com.example.homework_week8.activity.AddNoteActivity
import com.example.homework_week8.database.Note

class TakeNoteFragment : Fragment() {
    private val bindingFm by lazy { FragmentTakeNoteBinding.inflate(layoutInflater) }
    private lateinit var addNote: AddNoteActivity
    val note = mutableListOf<Note>()
    private val noteAdapter = NoteAdapter(note)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingFm.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteRecyclerView = bindingFm.recyclerViewTakeNote
        noteRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        //noteAdapter = NoteAdapter(emptyList()) // Khởi tạo adapter với danh sách rỗng ban đầu
        noteRecyclerView.adapter = noteAdapter

        val noteRoomDatabase = NoteRoomDatabase.getDatabase(requireContext())
        val noteDao = noteRoomDatabase.noteDao()

//        noteDao.getAllNote().observe(viewLifecycleOwner) { notes ->
//            noteAdapter.setData(notes)
//        }
        noteDao.getAllNote().observe(viewLifecycleOwner) { notes ->
            noteAdapter.setData(notes)
        }
    }
}