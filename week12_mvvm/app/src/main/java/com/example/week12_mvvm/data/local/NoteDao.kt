package com.example.week12_mvvm.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAllNote() : LiveData<List<LocalNote>>

    @Upsert
    suspend fun upsert(task : LocalNote)
    @Upsert
    suspend fun upsertAll(notes : List<LocalNote>)
    @Query("Delete From note")
    suspend fun deleteAll()
}