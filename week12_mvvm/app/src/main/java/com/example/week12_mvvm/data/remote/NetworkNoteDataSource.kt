package com.example.week12_mvvm.data.remote

import kotlinx.coroutines.delay
import java.util.Date

class NetworkNoteDataSource {
    private val noteList = mutableListOf<NetworkNote>(
        NetworkNote(
            id = null,
            title = "1",
            date = Date(),
            content = "1"
        ),
        NetworkNote(
            id = null,
            title = "2",
            date = Date(),
            content = "2"
        ),
        NetworkNote(
            id = null,
            title = "3",
            date = Date(),
            content = "3"
        ),
    )

    suspend fun getData() : List<NetworkNote>{
        delay(2000)
        return noteList
    }

    suspend fun create(networkNote: NetworkNote){
        delay(2000)
        noteList.add(networkNote)
    }
}