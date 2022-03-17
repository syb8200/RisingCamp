package com.example.risingcamp.week5_hw

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.R
import com.example.risingcamp.week3_hw.CU_bottom_nav

class Interpark_splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interpark_splash)

        val SPLASH_VIEW_TIME: Long = 2000

        Handler().postDelayed({
            startActivity(Intent(this, Interpark_bottom_nav::class.java))
            finish()
        }, SPLASH_VIEW_TIME)

        Log.d("인터파크 스플래쉬", "onCreate")
    }
}