package com.example.homework_week8.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.homework_week8.database.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("SELECT * FROM note_table")
    fun getAllNote(): LiveData<List<Note>>
}