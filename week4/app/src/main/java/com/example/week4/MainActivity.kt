package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val list = mutableListOf<User>(
        User("Dinh Linh", "Nghe An", R.drawable.heart_nav),
        User("Dang Tuan", "Ha Tinh", R.drawable.phone),
        User("Dinh Linh", "Nghe An", R.drawable.heart_nav),
        User("Dinh Linh", "Nghe An", R.drawable.phone),
        User("Dinh Linh", "Nghe An", R.drawable.heart_nav),
        User("Dinh Linh", "Nghe An", R.drawable.phone),
        User("Dinh Linh", "Nghe An", R.drawable.heart_nav),
        User("Dinh Linh", "Nghe An", R.drawable.phone),
        User("Dinh Linh", "Nghe An", R.drawable.heart_nav),
    )
    private val userAdapter = UserAdapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.input1.setOnClickListener {
            Toast.makeText(this, "This is button", Toast.LENGTH_LONG).show()
        }

        binding.recylerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        //binding.recylerView.layoutManager = GridLayoutManager(this, 2)
        binding.recylerView.adapter = userAdapter
    }
}