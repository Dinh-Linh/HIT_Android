package com.example.homewor_week4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homewor_week4.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var name: String
    private lateinit var pass: String
    private val list = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = intent.getStringExtra("username").toString()
        pass = intent.getStringExtra("pass").toString()
        list.add(User(name, pass, R.drawable.user_alt_light))
        val userAdapter = UserAdapter(list)
        binding.recylerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recylerView.adapter = userAdapter
    }
}