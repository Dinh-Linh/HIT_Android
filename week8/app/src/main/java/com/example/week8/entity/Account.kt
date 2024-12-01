package com.example.week8.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
data class Account(
    @PrimaryKey(autoGenerate = true)
    val id: String ?= null,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "password")
    val password: String
)
