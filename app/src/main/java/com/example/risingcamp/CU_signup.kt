package com.example.risingcamp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityCuSignupBinding

class CU_signup : AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding: ActivityCuSignupBinding

    //sharedpreferences
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuSignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        //getter로 데이터 가져오기
        val name = sharedPreferences.getString("Name", "ERROR")
        val birth = sharedPreferences.getInt("Birth", -1)
        val phone = sharedPreferences.getInt("Phone", -1)

        //textview에 가져온 데이터 보여주기
        binding.cuSignupName.text = name
        binding.cuSignupBirth.text = birth.toString()
        binding.cuSignupPhone.text = phone.toString()

        binding.cuSignupCompleteBtn.setOnClickListener{
            val intent = Intent(this, CU_login::class.java)
            startActivity(intent)
        }

        Log.d("Signup", "onCreate()")

    }
}