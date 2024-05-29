package com.example.week10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week10.databinding.ActivityMain2Binding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    private val auth = Firebase.auth
    private val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //auth.uid?.let { db.collection("users").document(it) }
        auth.currentUser?.let { user ->
            db.collection("users").document(user.uid)
                .get()
                .addOnSuccessListener { document ->
                    val user = document.toObject<User>()
                    binding.edtName.setText(user?.name.toString())
                    binding.edtAge.setText(user?.age.toString())
                    binding.edtAddress.setText(user?.address.toString())
                }.addOnFailureListener {

                }
        }
        binding.logOut.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
        binding.pubInf.setOnClickListener {
            auth.currentUser.let { user ->
                val newUser = User(
                    name = binding.edtName.text.toString(),
                    age = binding.edtAge.text.toString().toInt(),
                    address = binding.edtAddress.text.toString()
                )
                db.collection("users")
                    .document().set(newUser).addOnSuccessListener {
                        Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(this, exception.message, Toast.LENGTH_LONG).show()
                    }
            }
        }
        binding.getAllUser.setOnClickListener {
            db.collection("users").get().addOnSuccessListener { documents ->
                val userList = mutableListOf<User>()
                for (document in documents){
                    val user = document.toObject<User>()
                    userList.add(user)
                }
                println(userList)
            }
                .addOnFailureListener{

                }
            startActivity(Intent(this, MainActivity3::class.java))
        }

        binding.clearText.setOnClickListener{
            binding.edtName.clearText()
            binding.edtAddress.clearText()
            binding.edtAge.clearText()
        }
    }
}