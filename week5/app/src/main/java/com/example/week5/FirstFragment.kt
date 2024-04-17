package com.example.week5

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.week5.databinding.ActivityMainBinding
import com.example.week5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    var fullName: String? = null
    private val mainAc by lazy { activity as MainActivity }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {
            Toast.makeText(requireContext(), "This is toast", Toast.LENGTH_LONG).show()
            fullName = binding.fullName.text.toString()
            //val name = mainAc.fName
            //binding.fullName.setText(name)
        }
    }
}

