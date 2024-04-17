package com.example.week6

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.week6.databinding.ActivityMainBinding
import com.example.week6.databinding.DialogViewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = AlertDialog.Builder(this)
        dialog
            .setTitle("This is tilte!")
            .setMessage("This is Massage")
            .setView(R.layout.dialog_view)
            .setPositiveButton("Possitive") { dialog, _ ->
                Toast.makeText(this, "This is Toast", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Negative") { dialog, _ -> }
            .setNeutralButton("Neutral") { dialog, _ -> }

        val dialog2 = Dialog(this)
        val bindingDialog = DialogViewBinding.inflate(layoutInflater)
        dialog2.setContentView(bindingDialog.root)
        bindingDialog.btnGet.setOnClickListener {
            binding.getText1.text = bindingDialog.edtName.text.toString() + ' ' + bindingDialog.edtAddress.text.toString()
            dialog2.dismiss()
        }
        binding.button.setOnClickListener {
            dialog.show()
            //dialog2.show()
        }
    }
}