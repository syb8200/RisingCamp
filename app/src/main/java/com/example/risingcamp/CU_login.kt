package com.example.risingcamp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class CU_login: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cu_login)


        Log.d("Login", "onCreate")
    }
}