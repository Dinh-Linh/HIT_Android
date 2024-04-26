package com.example.sqlite_database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

data class Podcast(
    val id: Int,
    val name: String,
    val duration: String,
    val image: String,
    val author: String,
    val genre: String
)

class MyDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "my_database.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "my_podcast"
        private const val COLUMN_ID = "podcast_id"
        private const val COLUMN_NAME = "podcast_name"
        private const val COLUMN_DURATION = "podcast_duration"
        private const val COLUMN_IMAGE = "podcast_image"
        private const val COLUMN_AUTHOR = "podcast_author"
        private const val COLUMN_GENRE = "podcast_genre" //Thể loại postcard
    }


    //Tạo bảng database
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE =
            ("CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + "TEXT, " + COLUMN_DURATION + "TEXT, " +
                    COLUMN_IMAGE + "TEXT, " + COLUMN_AUTHOR + "TEXT, " +
                    COLUMN_GENRE + "TEXT, )")
        /* val CREATE_TABLE =
             "CREATE TABLE $TABLE_NAME (" +
                     "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "$COLUMN_NAME TEXT, " +
                     "$COLUMN_DURATION TEXT, " +
                     "$COLUMN_IMAGE TEXT, " +
                     "$COLUMN_AUTHOR TEXT, " +
                     "$COLUMN_GENRE TEXT)"*/
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Xoá bảng cũ neeus tồn tại
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        //Tạo lại bảng khi cần
        onCreate(db)
    }

    fun addPodcast(podcast: Podcast) {
        try {
            val database = this.writableDatabase
            val values = ContentValues().apply {
                put(COLUMN_NAME, podcast.name)
                put(COLUMN_AUTHOR, podcast.author)
                put(COLUMN_DURATION, podcast.duration)
                put(COLUMN_GENRE, podcast.genre)
                put(COLUMN_IMAGE, podcast.image)
            }
            val results: Long = database.insert(TABLE_NAME, null, values)
            if (results.toInt() == -1) {
                println("Add failed")
            } else {
                println("Add successful")
            }
            database.close()
        } catch (e: Exception) {
            println("Error adding podcast: ${e.message}")
            e.printStackTrace()
        }
    }


    @SuppressLint("Range")
    fun getPodcast(id: Int): Podcast? {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_AUTHOR,
                COLUMN_DURATION,
                COLUMN_IMAGE,
                COLUMN_GENRE
            ),
            "$COLUMN_ID=?",
            arrayOf(id.toString()),
            null,
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        var podcast: Podcast? = null
        cursor?.apply {
            if (moveToFirst()) {
                podcast = Podcast(
                    getInt(getColumnIndex(COLUMN_ID)),
                    getString(getColumnIndex(COLUMN_NAME)),
                    getString(getColumnIndex(COLUMN_DURATION)),
                    getString(getColumnIndex(COLUMN_IMAGE)),
                    getString(getColumnIndex(COLUMN_AUTHOR)),
                    getString(getColumnIndex(COLUMN_GENRE))
                )
            }
            close()
        }
        return podcast
    }

    fun updatePodcast(
        id: Int,
        name: String,
        duration: String,
        image: String,
        author: String,
        genre: String
    ): Int {
        val db = this.readableDatabase
        val values = ContentValues()
        values.put(COLUMN_ID, id)
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_IMAGE, image)
        values.put(COLUMN_AUTHOR, author)
        values.put(COLUMN_GENRE, genre)
        values.put(COLUMN_DURATION, duration)
        return db.update(TABLE_NAME, values, "$COLUMN_ID=?", arrayOf(id.toString()))
    }

    fun deletePodcast(id: Int) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_ID =?", arrayOf(id.toString()))
        db.close()
    }

    @SuppressLint("Range")
    fun getAllPodcast(): MutableList<Podcast> {
        val listPodcast = mutableListOf<Podcast>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        cursor?.use {
            if (it.moveToFirst()) {
                do {
                    val podcast = Podcast(
                        it.getInt(it.getColumnIndex(COLUMN_ID)),
                        it.getString(it.getColumnIndex(COLUMN_NAME)),
                        it.getString(it.getColumnIndex(COLUMN_DURATION)),
                        it.getString(it.getColumnIndex(COLUMN_AUTHOR)),
                        it.getString(it.getColumnIndex(COLUMN_IMAGE)),
                        it.getString(it.getColumnIndex(COLUMN_GENRE))
                    )
                    listPodcast.add(podcast)
                } while (it.moveToNext())
            }
        }
        cursor?.close()
        return listPodcast
    }
}