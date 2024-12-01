package com.example.week12_mvvm.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week12_mvvm.adapter.NoteAdapter
import com.example.week12_mvvm.view_model.ListViewModel
import com.example.week12_mvvm.MainActivity
import com.example.week12_mvvm.R
import com.example.week12_mvvm.data.data_class.Note
import com.example.week12_mvvm.databinding.FragmentTakeNoteBinding


class TakeNoteFragment : Fragment() {
    private val bindingFm by lazy { FragmentTakeNoteBinding.inflate(layoutInflater) }
    var note = mutableListOf<Note>()


    private val viewModel by lazy { ViewModelProvider(this)[ListViewModel::class.java] }
    private fun onItemClick(note: Note) {
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }

    private val noteAdapter = NoteAdapter() { note -> onItemClick(note) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.refresh()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingFm.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingFm.addNote.setOnClickListener {
            findNavController().navigate(R.id.action_takeNoteFragment_to_addNoteFragment2)
        }
        viewModel.noteList.observe(viewLifecycleOwner) { list ->
            noteAdapter.setData(list.toMutableList())
        }
        bindingFm.recyclerViewTakeNote.layoutManager = LinearLayoutManager(requireContext())
        bindingFm.recyclerViewTakeNote.adapter = noteAdapter
        viewModel.noteList.observe(viewLifecycleOwner) { list ->
            noteAdapter.setData(list.toMutableList())
        }

    }

}