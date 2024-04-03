package com.example.homework_week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.homework_week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fragmentContainer.id, homeFragment)
            setReorderingAllowed(true)
        }

        binding.home.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, homeFragment)
                setReorderingAllowed(true)
            }
        }

        binding.profile.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, profileFragment)
                setReorderingAllowed(true)
            }
        }
    }
}