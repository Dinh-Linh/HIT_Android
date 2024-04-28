package com.example.homework_week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.homework_week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fmTakeNote = TakeNoteFragment()
    private val fmFavourite = FavouriteTakeNoteFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fmContainer.id, fmTakeNote)
        }
        binding.takeNote.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fmContainer.id, fmTakeNote)
            }
        }

        binding.favourite.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fmContainer.id, fmFavourite)
            }
        }

        binding.addNote.setOnClickListener{
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }
}