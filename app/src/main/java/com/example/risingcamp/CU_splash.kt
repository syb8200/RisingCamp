package com.example.risingcamp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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