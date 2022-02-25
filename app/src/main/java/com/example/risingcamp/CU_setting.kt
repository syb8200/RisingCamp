package com.example.risingcamp

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityCuSettingBinding

class CU_setting : AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding : ActivityCuSettingBinding

    //sharedpreferences
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuSettingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)



        //[데이터 가져오기]
        //getter로 데이터 가져오기
        val name = sharedPreferences.getString("Name", "ERROR")
        val birth = sharedPreferences.getString("Birth", "ERROR")
        val phone = sharedPreferences.getString("Phone", "ERROR")
        val pwd = sharedPreferences.getString("Password", "ERROR")

        binding.cuSettingId.text = name

        binding.cuSettingLogoutBtn.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("로그아웃")
                .setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("확인", DialogInterface.OnClickListener{dialog, which ->

                    binding.cuSettingId.text = null

                    val editor : SharedPreferences.Editor = sharedPreferences.edit()

                    editor.putString("Name", null)
                    editor.putString("Birth", null)
                    editor.putString("Phone", null)
                    editor.putString("Password", null)

                    //apply로 데이터를 파일에 반영
                    editor.apply()

                    finish()

                })
            builder.show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        finishAffinity() //해당 앱의 루트 액티비티를 종료시킨다.
        System.runFinalization() //현재 작업중인 쓰레드가 다 종료되면, 종료 시키라는 명령어이다.
        System.exit(0) // 현재 액티비티를 종료시킨다.

    }


}