package com.example.week12_mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.week12_mvvm.data.local.LocalNote
import com.example.week12_mvvm.data.local.NoteDao
import com.example.week12_mvvm.data.local.toListNote
import com.example.week12_mvvm.data.local.toLocalNote
import com.example.week12_mvvm.data.remote.NetworkNoteDataSource
import com.example.week12_mvvm.data.remote.toNetworkNote
import com.example.week12_mvvm.data.remote.toNote

class NoteRepository(
    private val noteDao: NoteDao,
    private val networkNoteDataSource: NetworkNoteDataSource
) {
    fun getAll():LiveData<List<Note>> {
        return noteDao.getAllNote().map {localNotes : List<LocalNote> ->
            localNotes.toListNote()
        }
    }

    suspend fun refresh(){
        val networkData = networkNoteDataSource.getData().map {networkNote ->
            networkNote.toNote()
        }
        noteDao.deleteAll()
        noteDao.upsertAll(networkData.map {note ->
            note.toLocalNote()
        })
    }
    suspend fun create(note: Note){
        noteDao.upsert(note.toLocalNote())
        networkNoteDataSource.create(note.toNetworkNote())
    }

}