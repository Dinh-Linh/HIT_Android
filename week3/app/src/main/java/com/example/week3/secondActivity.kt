package com.example.week3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class secondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val content = intent.getStringExtra("key")
        val textView: Button = findViewById(R.id.btn)
        textView.text = "Bạn vừa nhập " + content

        var user:User? = intent.getParcelableExtra("user")
        if(user != null){
            textView.text = user.userName
        }
        textView.text = user.toString()

        val content1:TextView = findViewById(R.id.id1)
        content1.text = "Bạn vừa nhập " + intent.getStringExtra("key")
    }
}