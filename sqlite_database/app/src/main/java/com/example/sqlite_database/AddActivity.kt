package com.example.sqlite_database

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlite_database.databinding.ActivityAddBinding
import com.example.sqlite_database.databinding.ActivityMainBinding

class AddActivity : AppCompatActivity() {
    private lateinit var bindingAdd: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAdd = ActivityAddBinding.inflate(layoutInflater)
        setContentView(bindingAdd.root)

        bindingAdd.addButton.setOnClickListener {
            MyDatabaseHelper(this).addPodcast(
                podcast = Podcast(
                    bindingAdd.idPodcast.text.toString().toInt(),
                    bindingAdd.name.text.toString(),
                    bindingAdd.duration.text.toString(),
                    bindingAdd.image.text.toString(),
                    bindingAdd.author.text.toString(),
                    bindingAdd.gerne.text.toString()
                )
            )
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}