package com.example.homewor_week4

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.homewor_week4.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val color = ContextCompat.getColor(this, R.color.blue)
        binding.signUp.setOnClickListener{
            if (checkPassword() == false){
                binding.incorrectPassword.setText("Mật khẩu không trùng khớp")
            }
            else{
                binding.incorrectPassword.setText("Mật khẩu trùng khớp")
            }
            checkPasswordCorrect()
        }

        binding.login.setOnClickListener{
            intent = Intent(this, LoginForm ::class.java)
            startActivity(intent)
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
    private fun checkPasswordCorrect():Boolean{
        val pass = binding.password.text.toString()
        var n = 0
        var c = 0
        if(pass != null){
            if(pass.length < 8){
                return false
            }
            else{
                changeTextColor(binding.check12, Color.BLUE)
                changeImgColor(binding.check11, Color.BLUE)
                for (i in pass){
                    if (i.isLetter()){
                        c++
                    }
                    else if (i.isDigit()){
                        n++
                    }
                }
                if (c*n > 0){
                    changeTextColor(binding.check32, Color.BLUE)
                    changeImgColor(binding.check31, Color.BLUE)
                }
                if (pass.any({it.isUpperCase()}) && pass.any({it.isLowerCase()})){
                    changeTextColor(binding.check22, Color.BLUE)
                    changeImgColor(binding.check21, Color.BLUE)
                }
                return true
            }
        }
        return false
    }

    private fun changeTextColor(textView: TextView, color: Int) {
        textView.setTextColor(color)
    }

    private fun changeImgColor(imgView: ImageView, color: Int) {
        imgView.setColorFilter(color)
    }
}