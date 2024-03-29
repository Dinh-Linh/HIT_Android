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
        val username = binding.username.text.toString()
        val address = binding.password.text.toString()
        val user = User(username, 19, address, R.drawable.user_alt_light)
       //intent.putExtra("username", username)
        //intent.putExtra("address", address)
        intent.putExtra("user",user.toString())
        binding.login.setOnClickListener{
            startActivity(Intent(this, Home::class.java))
        }

        binding.signUp.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}

