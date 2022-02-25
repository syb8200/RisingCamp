package com.example.risingcamp

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
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

        //[데이터 가져오기]
        //getter로 데이터 가져오기
        val name = sharedPreferences.getString("Name", "ERROR")
        val birth = sharedPreferences.getString("Birth", "ERROR")
        val phone = sharedPreferences.getString("Phone", "ERROR")

        //상단 textview 3개에 가져온 데이터 보여주기
        binding.cuSignupName.text = name
        binding.cuSignupBirth.text = birth
        binding.cuSignupPhone.text = phone

        //하단 textview 1개에 가져온 데이터 보여주기
        binding.cuSignupId.text = phone

        binding.cuSignupCompleteBtn.setOnClickListener{
            val intent = Intent(this, CU_complete_signup::class.java)

            if(binding.cuSignupPwd!=binding.cuSignupPwdCheck){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("오류")
                    .setMessage("비밀번호가 일치하지 않습니다.")
                    .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, which->
                    })
                builder.show()
            }

            startActivity(intent)
        }

        Log.d("Signup", "onCreate()")

    }

    override fun onStop() {
        super.onStop()

        //[데이터 집어넣기]
        //입력한 데이터 가져오기
        val pwd = binding.cuSignupPwd.text.toString()

        //SharedPreferences.Editor 객체 가져오기, putter로 데이터 저장하기
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("Password", pwd)

        //apply로 데이터를 파일에 반영
        editor.apply()
    }
}