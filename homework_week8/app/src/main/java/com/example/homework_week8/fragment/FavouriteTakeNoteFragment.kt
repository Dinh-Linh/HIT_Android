package com.example.homework_week8.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_week8.NoteAdapter
import com.example.homework_week8.activity.MainActivity
import com.example.homework_week8.databinding.FragmentFavouriteTakeNoteBinding

class FavouriteTakeNoteFragment : Fragment() {
    private val bindingFm by lazy { FragmentFavouriteTakeNoteBinding.inflate(layoutInflater) }
    private lateinit var noteAdapter: NoteAdapter
    private val mainActivity by lazy { activity as MainActivity}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val reFavourite = bindingFm.recyclerFavourite
        noteAdapter = NoteAdapter(mainActivity.favourite)
        reFavourite.adapter = noteAdapter
        reFavourite.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingFm.root
    }

    override fun onStart() {
        super.onStart()
        noteAdapter.setData(mainActivity.favourite)
    }
}