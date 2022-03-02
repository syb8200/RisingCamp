package com.example.risingcamp.second_third_week

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityCuCompleteSignupBinding

class CU_complete_signup : AppCompatActivity() {

    // 뷰 바인딩
    private lateinit var binding : ActivityCuCompleteSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuCompleteSignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.cuCompleteSignupOk.setOnClickListener{
            val intent = Intent(this, CU_login::class.java)
            startActivity(intent)
        }


    }
}