package com.example.week12_mvvm.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_week8.NoteAdapter
import com.example.week12_mvvm.R
import com.example.week12_mvvm.data.Note
import com.example.week12_mvvm.databinding.FragmentTakeNoteBinding


class TakeNoteFragment : Fragment() {
    private val bindingFm by lazy { FragmentTakeNoteBinding.inflate(layoutInflater) }
    var note = mutableListOf<Note>()
    private val noteAdapter = NoteAdapter(note)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val noteRecyclerView = bindingFm.recyclerViewTakeNote
        noteRecyclerView.layoutManager = LinearLayoutManager(requireContext());
        noteRecyclerView.adapter = noteAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return bindingFm.root
    }

}