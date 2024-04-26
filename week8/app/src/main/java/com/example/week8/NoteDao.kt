package com.example.week8

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun addNode(note: Note)

    @Delete
    fun deleteNote(note: Note)
    @Query("SELECT * FROM note_table")
    fun getAllNote() : List<Note>
}