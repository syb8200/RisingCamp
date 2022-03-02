package com.example.risingcamp.week3_hw

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.R

class CU_splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cu_splash)

        val SPLASH_VIEW_TIME: Long = 2000

        Handler().postDelayed({
            startActivity(Intent(this, CU_bottom_nav::class.java))
            finish()
        }, SPLASH_VIEW_TIME)

        Log.d("Splash", "onCreate")
    }
}