package com.example.week8.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.week8.constant.EntityRoomDatabase
import com.example.week8.dao.AccountDao
import com.example.week8.entity.Account

@Database(entities = [Account::class], version = 2, exportSchema = false)
abstract class AccountRoomDatabase : RoomDatabase() {
    abstract fun getDao() : AccountDao

    companion object {
        @Volatile
        private var INSTANCE: AccountRoomDatabase? = null
        fun getDatabase(context: Context): AccountRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccountRoomDatabase::class.java,
                    "account_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}