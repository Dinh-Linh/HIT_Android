package com.example.week12_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week12_mvvm.data.Note
import com.example.week12_mvvm.data.NoteRepository
import com.example.week12_mvvm.data.local.NoteRoomDatabase
import com.example.week12_mvvm.data.remote.NetworkNoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date

class ListViewModel :ViewModel() {
   /* private val _result = MutableLiveData<Int>(0)
    val result : LiveData<Int> get() = _result

    fun Plus(){
        if (_result.value != null){
            _result.value = _result.value!! + 1
        }
    }*/

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