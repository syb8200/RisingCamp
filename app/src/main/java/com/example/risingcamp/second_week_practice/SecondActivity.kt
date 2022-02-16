package com.example.risingcamp.second_week_practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivitySecondPractice2Binding

class SecondActivity : AppCompatActivity(){

    lateinit var binding:ActivitySecondPractice2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondPractice2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtSecond.text = intent.getStringExtra("data")
    }
}