package com.example.week8.constant

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 2, exportSchema = false)
abstract class EntityRoomDatabase<T : Any, D> : RoomDatabase() {
    abstract fun getDao(): D

    companion object {
        @Volatile
        private var INSTANCE: EntityRoomDatabase<*, *>? = null

        @Suppress("UNCHECKED_CAST")
        fun <T : Any, D> getDatabase(
            context: Context,
            databaseClass: Class<out EntityRoomDatabase<T, D>>,
            dbName: String
        ): EntityRoomDatabase<T, D> {
            return INSTANCE as EntityRoomDatabase<T, D> ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    databaseClass,
                    dbName
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}