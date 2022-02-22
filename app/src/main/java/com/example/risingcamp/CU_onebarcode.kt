package com.example.risingcamp

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityCuOneBarcodeBinding

class CU_onebarcode : AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding : ActivityCuOneBarcodeBinding

    //sharedpreferences
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuOneBarcodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

    }


    override fun onResume() {
        super.onResume()

        //getter로 데이터 가져오기
        val name = sharedPreferences.getString("Name", "ERROR")
        binding.cuOneBarcodeName.text = name


        //Log.d("OneBarcode", "onStart(), $id")

    }



/*    override fun onPause() {
        super.onPause()

        //입력한 데이터 가져오기 (login_value)
        val point = sharedPreferences.getString("Point", "ERROR")

        //SharedPreferences.Editor 객체 가져오기, putter로 데이터 저장하기
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("Point", "700")

        Log.d("OneBarcode", "onPause()")

        //apply로 데이터를 파일에 반영
        editor.apply()


    }*/
}