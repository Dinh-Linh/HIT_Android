package com.example.homewor_week4

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homewor_week4.databinding.ActivityLoginBinding
import com.example.homewor_week4.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUp.setOnClickListener{
            if (checkPassword() == false){
                binding.incorrectPassword.setText("Mật khẩu không trùng khớp")
            }
            else{
                binding.incorrectPassword.setText("Mật khẩu trùng khớp")
            }
        }

    }

    private fun checkPassword() : Boolean{
        try{
            if(binding.password.text.toString().equals(binding.passwordRequest.text.toString())){
                return true
            }
            return false
        }
        catch (e:Exception){
            return false
        }
    }
}