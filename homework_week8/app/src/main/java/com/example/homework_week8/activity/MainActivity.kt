package com.example.homework_week8.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.commit
import com.example.homework_week8.fragment.FavouriteTakeNoteFragment
import com.example.homework_week8.R
import com.example.homework_week8.database.NoteRoomDatabase
import com.example.homework_week8.fragment.TakeNoteFragment
import com.example.homework_week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fmTakeNote = TakeNoteFragment()
    private val fmFavourite = FavouriteTakeNoteFragment()
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val colorBlack = resources.getColor(R.color.black)
        val colorWhite = resources.getColor(R.color.white)
        supportFragmentManager.commit {
            replace(binding.fmContainer.id, fmTakeNote)
        }
        binding.takeNote.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fmContainer.id, fmTakeNote)
            }
            binding.color1.setBackgroundColor(colorBlack)
            binding.color2.setBackgroundColor(colorWhite)
        }

        binding.favourite.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fmContainer.id, fmFavourite)
            }
            binding.color1.setBackgroundColor(colorWhite)
            binding.color2.setBackgroundColor(colorBlack)
            Toast.makeText(this, "Convert Successful",Toast.LENGTH_LONG).show()
        }

        binding.addNote.setOnClickListener{
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }
}