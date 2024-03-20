package com.example.homeworkweek2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list:List<Int> = listOf(1,2,3,4,5)
        println(list)
        println(func1(5,10))
    }
    private fun func1(v1:Int, v2:Int):Int {
        return v1+v2
    }

}