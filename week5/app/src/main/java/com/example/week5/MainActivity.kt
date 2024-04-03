package com.example.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.bumptech.glide.Glide
import com.example.week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()

    //private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*   Glide.with(this)
               .load("https://giphy.com/clips/justin-MEdRTaYvZBlVMEjwZ3").into(binding.img)*/

        Glide.with(this).load("https://image.dienthoaivui.com.vn/x,webp,q90/https://dashboard.dienthoaivui.com.vn/uploads/dashboard/editor_upload/hinh-nen-may-tinh-4k-17.jpg").into(binding.btnFirstFragment)
        binding.btnFirstFragment.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fmContainer.id, firstFragment)
                setReorderingAllowed(true)
            }
        }

        binding.btnSecondFragment.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fmContainer.id, secondFragment)
                setReorderingAllowed(true)
            }
        }
    }
}