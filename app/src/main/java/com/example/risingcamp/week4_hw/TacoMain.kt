package com.example.risingcamp.week4_hw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityTacoMainBinding

class TacoMain : AppCompatActivity() {

    private lateinit var binding : ActivityTacoMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTacoMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


    }
}