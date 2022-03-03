package com.example.risingcamp.week4_pt

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.R
import com.example.risingcamp.databinding.ActivityMainPractice4Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMainPractice4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPractice4Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        var pictureChangeArrayList = ArrayList<Int>()

        var handler = Handler(Looper.getMainLooper())

        pictureChangeArrayList.add(R.drawable.animal_dog)
        pictureChangeArrayList.add(R.drawable.animal_cat)
        pictureChangeArrayList.add(R.drawable.animal_tiger)
        pictureChangeArrayList.add(R.drawable.animal_rabbit)

        Thread(){
            for(i in pictureChangeArrayList){ //foreach문

                Thread.sleep(1000)

                handler.post{
                    binding.imgMainChagePicture.setImageResource(i)
                }
            }
        }.start()

    }
}