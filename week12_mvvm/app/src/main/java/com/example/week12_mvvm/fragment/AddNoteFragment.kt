package com.example.week12_mvvm.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week12_mvvm.R
import com.example.week12_mvvm.databinding.FragmentAddNoteBinding


class AddNoteFragment : Fragment() {
    private val bindingFm by lazy { FragmentAddNoteBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingFm.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingFm.saveNote.setOnClickListener{
            findNavController().popBackStack()
        }
    }
}