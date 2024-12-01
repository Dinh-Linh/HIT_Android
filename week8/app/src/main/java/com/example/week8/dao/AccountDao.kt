package com.example.week8.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.week8.entity.Account

@Dao
interface AccountDao {
    @Insert
    fun createAccount(username : String, password : String)
    @Delete
    fun deleteAccount(account: Account)
}