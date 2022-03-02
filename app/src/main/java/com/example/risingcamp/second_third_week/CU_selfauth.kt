package com.example.risingcamp.second_third_week

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityCuSelfauthBinding

class CU_selfauth : AppCompatActivity()  {

    //뷰 바인딩
    private lateinit var binding : ActivityCuSelfauthBinding

    //sharedpreferences
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuSelfauthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        binding.cuSelfauthBtn.setOnClickListener{
            val intent = Intent(this, CU_selfauth_check::class.java)
            startActivity(intent)
        }

        Log.d("SelfAuth", "onCreate()")
    }

    override fun onStop() {
        super.onStop()

        //입력한 데이터 가져오기
        val name = binding.cuSelfauthName.text.toString()
        val birth = binding.cuSelfauthBirth.text.toString()
        val phone = binding.cuSelfauthPhone.text.toString()

        //SharedPreferences.Editor 객체 가져오기, putter로 데이터 저장하기
        val editor : SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString("Name", name)
        editor.putString("Birth", birth)
        editor.putString("Phone", phone)

        //apply로 데이터를 파일에 반영
        editor.apply()

        Log.d("SelfAuth", "onStop()")

    }


}