package com.example.week12_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week12_mvvm.data.Note
import java.util.Date

class ListViewModel :ViewModel() {
   /* private val _result = MutableLiveData<Int>(0)
    val result : LiveData<Int> get() = _result

    fun Plus(){
        if (_result.value != null){
            _result.value = _result.value!! + 1
        }
    }*/

    private val _noteList = MutableLiveData<List<Note>>()
    val noteList : LiveData<List<Note>> get() = _noteList
    fun getData(){
        _noteList.value = fakeData
    }
    private val fakeData = mutableListOf<Note>(
        Note(
            title = "Title 1",
            date = Date(),
            content = "Content 1",
        ),
        Note(
            title = "Title 2",
            date = Date(),
            content = "Content 2",
        ),
        Note(
            title = "Title 3",
            date = Date(),
            content = "Content 3",
        ),
        Note(
            title = "Title 4",
            date = Date(),
            content = "Content 6",
        ),
        Note(
            title = "Title 5",
            date = Date(),
            content = "Content 5",
        )

    )

}