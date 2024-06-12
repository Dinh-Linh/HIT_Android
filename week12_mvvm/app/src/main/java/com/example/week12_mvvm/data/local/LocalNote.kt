package com.example.week12_mvvm.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.week12_mvvm.data.Note
import java.util.Date

@Entity(tableName = "note")
data class LocalNote(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String?,
    val date: Date?,
    val content: String?

)

fun LocalNote.toNote() : Note{
    return Note(
        id = id,
        title = title!!,
        content = content!!,
        date = date!!
    )
}

fun List<LocalNote>.toListNote() : List<Note>{
    return map {
        it.toNote()
    }
}
fun Note.toLocalNote() : LocalNote{
    return LocalNote(
        id = id,
        title = title,
        content = content,
        date = date
    )
}
