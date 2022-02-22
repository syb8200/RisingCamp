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



        //getter로 데이터 가져오기
        val name = sharedPreferences.getString("Name", "ERROR")
        //val id = sharedPreferences.getString("ID", "ERROR")
        binding.cuSettingId.text = name
        //val pwd = sharedPreferences.getString("PWD", "ERROR")
        //val login_value = sharedPreferences.getString("Login", "ERROR")

        /*
        if(login_value=="logout"){
            binding.cuSettingId.text = "로그인 해주세요."
        } else if(login_value=="login"){
            binding.cuSettingId.text = id
        }
        */


        binding.cuSettingLogoutBtn.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("로그아웃")
                .setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("확인", DialogInterface.OnClickListener{dialog, which ->
                    finish()

                })
            builder.show()
        }

    }

    override fun onStop() {
        super.onStop()

        //val name = null
        //val birth = 0
        //val phone = 0

        val editor : SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString("Name", null)
        editor.putInt("Birth", 0)
        editor.putInt("Phone", 0)

        //apply로 데이터를 파일에 반영
        editor.apply()

        //Log.d("Setting", "onDestroy(), ID:$id PWD:$pwd, Login:$login_value")
    }


    override fun onDestroy() {
        super.onDestroy()

        finishAffinity() //해당 앱의 루트 액티비티를 종료시킨다.
        System.runFinalization() //현재 작업중인 쓰레드가 다 종료되면, 종료 시키라는 명령어이다.
        System.exit(0) // 현재 액티비티를 종료시킨다.

    }


}