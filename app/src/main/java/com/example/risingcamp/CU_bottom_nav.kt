package com.example.risingcamp

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.risingcamp.databinding.ActivityCuBottomNavBinding

class CU_bottom_nav : AppCompatActivity() {

    // 뷰바인딩 사용
    private lateinit var binding: ActivityCuBottomNavBinding

    //sharedpreferences
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuBottomNavBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user_login", MODE_PRIVATE)

        //getter로 데이터 가져오기
        val id = sharedPreferences.getString("ID", "ERROR")
        val pwd = sharedPreferences.getString("PWD", "ERROR")

        binding.cuOneBarcode.setOnClickListener{
            val intent = Intent(this, CU_onebarcode::class.java)
            startActivity(intent)
        }


        //bottom_nav 클릭 리스너 생성
        initNavigationBar()
    }

    private fun initNavigationBar(){
        binding.cuBottomNav.run{
            setOnItemSelectedListener { item ->
                when(item.itemId){
                    R.id.cu_home ->
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.cu_container, CU_home_Fragment())
                            .commit()

                    R.id.cu_mycu ->
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.cu_container, CU_mycu_Fragment())
                            .commit()

                    R.id.cu_coupon ->
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.cu_container, CU_coupon_Fragment())
                            .commit()

                    R.id.cu_buylist ->
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.cu_container, CU_buylist_Fragment())
                            .commit()
                }
                true
            }
            selectedItemId = R.id.cu_home
        }
    }

}