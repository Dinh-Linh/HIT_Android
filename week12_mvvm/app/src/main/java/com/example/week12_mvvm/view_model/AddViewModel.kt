package com.example.week12_mvvm.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week12_mvvm.MyApplication
import com.example.week12_mvvm.data.data_class.Note
import com.example.week12_mvvm.data.repository.NoteRepository
import com.example.week12_mvvm.data.local.NoteRoomDatabase
import com.example.week12_mvvm.data.remote.NetworkNoteDataSource
import kotlinx.coroutines.launch

class AddViewModel :ViewModel() {
    private val repository = NoteRepository(
        NoteRoomDatabase.getDatabase(MyApplication.getContext()).noteDao(),
        NetworkNoteDataSource()
    )
    fun createNote(note : Note){
        viewModelScope.launch {
            repository.create(note)
        }
    }
}