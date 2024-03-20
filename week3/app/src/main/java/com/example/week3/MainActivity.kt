package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        
    }

    override fun onStart() {
        super.onStart()
        print("on start")
    }

    override fun onResume() {
        super.onResume()
        print("on resume")
    }

    override fun onStop() {
        super.onStop()
        print("on stop")
    }
}