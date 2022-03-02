package com.example.risingcamp.week3_hw

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityCuBeforeSignupBinding

class CU_before_signup : AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding : ActivityCuBeforeSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuBeforeSignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d("Before_Signup", "onCreate")


        binding.cuBeforeSignupBtn.setOnClickListener{
            val intent = Intent(this, CU_selfauth::class.java)
            startActivity(intent)

            Log.d("Before_Singup", "Before_Signup_btn selected")
        }

    }
}