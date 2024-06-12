package com.example.week12_mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week12_mvvm.data.Note
import com.example.week12_mvvm.data.NoteRepository
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