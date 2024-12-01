package com.example.week12_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week12_mvvm.MyApplication
import com.example.week12_mvvm.data.data_class.Note
import com.example.week12_mvvm.data.repository.NoteRepository
import com.example.week12_mvvm.data.local.NoteRoomDatabase
import com.example.week12_mvvm.data.remote.NetworkNoteDataSource
import kotlinx.coroutines.launch

class ListViewModel :ViewModel() {

    private val repository = NoteRepository(
        NoteRoomDatabase.getDatabase(MyApplication.getContext()).noteDao(),
        NetworkNoteDataSource()
    )
    val noteList : LiveData<List<Note>> = repository.getAll()

    fun refresh(){
        viewModelScope.launch {
            repository.refresh()
        }
    }
}