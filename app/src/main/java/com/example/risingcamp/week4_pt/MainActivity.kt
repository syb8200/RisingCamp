package com.example.risingcamp.week4_pt

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityMainPractice4Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainPractice4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPractice4Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        Thread(){
            for(i in 0 until 1001){
                println(i)
            }
        }.start()

        Thread(){
            for(i in 1000 downTo 0){
                println(i)
            }
        }.start()
    }
}