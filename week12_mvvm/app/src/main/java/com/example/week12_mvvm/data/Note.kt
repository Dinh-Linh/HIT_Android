package com.example.week12_mvvm.data

import java.util.Date

data class Note(
    val id:Int?=null,
    val title:String,
    val content:String,
    val date: Date
)