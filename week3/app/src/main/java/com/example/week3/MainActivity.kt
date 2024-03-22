package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val editText:EditText = findViewById(R.id.eText)
        button.setOnClickListener(){
            println("You was be blocked by your crush")
            val content = editText.text.toString()
          //  Toast.makeText(this, "This is Toast", Toast.LENGTH_LONG).show()
            val intent = Intent(this, secondActivity::class.java)
            intent.putExtra("key", content) // truyền dữ liệu qua màn khác

            val user = User("Dinh Linh", true)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

}