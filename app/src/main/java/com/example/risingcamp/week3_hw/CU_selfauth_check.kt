package com.example.risingcamp.week3_hw

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityCuSelfauthCheckBinding

class CU_selfauth_check : AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding : ActivityCuSelfauthCheckBinding

    //sharedpreferences
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuSelfauthCheckBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        //getter로 데이터 가져오기
        val name = sharedPreferences.getString("Name", "ERROR")
        val birth = sharedPreferences.getString("Birth", "ERROR")
        val phone = sharedPreferences.getString("Phone", "ERROR")

        //textview에 가져온 데이터 보여주기
        binding.cuSelfauthCheckName.text = name
        binding.cuSelfauthCheckBirth.text = birth
        binding.cuSelfauthCheckPhone.text = phone

        binding.cuSelfauthCompleteBtn.setOnClickListener{
            val intent = Intent(this, CU_signup::class.java)
            startActivity(intent)
        }

        Log.d("SelfAuthCheck", "onCreate()")

    }

    override fun onDestroy() {
        super.onDestroy()

        binding.cuSelfauthCheckName.text = null
        binding.cuSelfauthCheckBirth.text = null
        binding.cuSelfauthCheckPhone.text = null

    }
}