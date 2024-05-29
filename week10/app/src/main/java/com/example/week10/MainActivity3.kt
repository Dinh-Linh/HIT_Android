package com.example.week10

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week10.databinding.ActivityMain3Binding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class MainActivity3 : AppCompatActivity() {
    private val binding by lazy { ActivityMain3Binding.inflate(layoutInflater) }
    private val auth = Firebase.auth
    private val db = Firebase.firestore
    private val userAdapter = UserAdapter{onItemClick(it)}

    private fun onItemClick(view : TextView){
        Toast.makeText(this, view.text, Toast.LENGTH_LONG).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = userAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        db.collection("users").get().addOnSuccessListener { documents ->
            val userList = mutableListOf<User>()
            for (document in documents) {
                val user = document.toObject<User>()
                userList.add(user)
            }
            userAdapter.setList(userList)
        }
            .addOnFailureListener {

            }

        db.collection("users").addSnapshotListener { value, err ->
            val userList = mutableListOf<User>()
            if (value != null) {
                for (document in value) {
                    val user = document.toObject<User>()
                    userList.add(user)
                }
            }
            userAdapter.setList(userList)
        }
    }
}