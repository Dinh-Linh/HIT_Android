package com.example.week12_mvvm.data.remote

import com.example.week12_mvvm.data.data_class.Note
import java.util.Date

data class NetworkNote(
    val id: Int? = null,
    val title: String?,
    val date: Date?,
    val content: String?
)

fun NetworkNote.toNote() : Note {
    return Note(
        id = id,
        title = title!!,
        content = content!!,
        date = date!!
    )
}

fun List<NetworkNote>.toListNote() : List<Note>{
    return map {
        it.toNote()
    }
}
fun Note.toNetworkNote() : NetworkNote {
    return NetworkNote(
        id = id,
        title = title,
        content = content,
        date = date
    )
}