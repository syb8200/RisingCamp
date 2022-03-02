package com.example.risingcamp.second_third_week

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityCuLoginBinding

class CU_login: AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding : ActivityCuLoginBinding

    //sharedpreferences
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        //회원가입 텍스트
        binding.cuLoginSignupTxt.setOnClickListener{
            val intent = Intent(this, CU_before_signup::class.java)
            startActivity(intent)
        }

        //로그인 버튼
        binding.cuLoginBtn.setOnClickListener{
            val intent = Intent(this, CU_bottom_nav::class.java)
            startActivity(intent)
        }

        Log.d("Login", "onCreate")
    }

    override fun onRestart() {
        super.onRestart()

        val builder2 = AlertDialog.Builder(this)

        builder2.setTitle("보안")
            .setMessage("보안상의 이유로 초기화됩니다.")
            .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, which->
            })
        builder2.show()

        Log.d("Login", "onRestart()")

    }

    override fun onPause() {
        super.onPause()

        binding.cuLoginIdEdt.text = null
        binding.cuLoginPwdEdt.text = null

    }

}