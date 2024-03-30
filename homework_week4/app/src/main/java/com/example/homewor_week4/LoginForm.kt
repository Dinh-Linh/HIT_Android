package com.example.homewor_week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homewor_week4.databinding.ActivityLoginBinding

class LoginForm : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, Home::class.java)
        binding.login.setOnClickListener{
            val username = binding.username.text.toString()
            val pass = binding.password.text.toString()
            intent.putExtra("username", username)
            intent.putExtra("pass", pass)
            startActivity(intent)
        }

        binding.signUp.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}

