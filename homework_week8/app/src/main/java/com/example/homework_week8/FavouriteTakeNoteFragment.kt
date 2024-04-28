package com.example.homework_week8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_week8.databinding.FragmentTakeNoteBinding
import com.example.week8.NoteRoomDatabase

class FavouriteTakeNoteFragment : Fragment() {
    private val bindingFm by lazy { FragmentTakeNoteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return bindingFm.root
    }

}