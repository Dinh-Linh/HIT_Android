package com.example.week12_mvvm.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week12_mvvm.AddViewModel
import com.example.week12_mvvm.R
import com.example.week12_mvvm.data.Note
import com.example.week12_mvvm.databinding.FragmentAddNoteBinding
import java.util.Date


class AddNoteFragment : Fragment() {
    private val bindingFm by lazy { FragmentAddNoteBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[AddViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingFm.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingFm.saveNote.setOnClickListener{
            findNavController().popBackStack()
            val note = Note(
                id = null,
                title = bindingFm.getTiltle.text.toString(),
                date = Date(),
                content = bindingFm.getContent.text.toString()
            )
            viewModel.createNote(note)
        }
    }
}