package com.example.risingcamp.week5_hw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.R
import com.example.risingcamp.databinding.ActivityCuBottomNavBinding
import com.example.risingcamp.databinding.ActivityInterparkBottomNavBinding
import com.example.risingcamp.week3_hw.CU_buylist_Fragment
import com.example.risingcamp.week3_hw.CU_coupon_Fragment
import com.example.risingcamp.week3_hw.CU_home_Fragment
import com.example.risingcamp.week3_hw.CU_mycu_Fragment

class Interpark_bottom_nav : AppCompatActivity(){

    // 뷰바인딩 사용
    private lateinit var binding: ActivityInterparkBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInterparkBottomNavBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //bottom_nav 클릭 리스너 생성
        initNavigationBar()

    }

    private fun initNavigationBar(){
        binding.interparkBottomNav.run{
            setOnItemSelectedListener { item ->
                when(item.itemId){
                    R.id.interpark_home ->
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.interpark_container, Interpark_fragment_home())
                            .commit()

                    R.id.interpark_category ->
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.interpark_container, Interpark_fragment_category())
                            .commit()

                    R.id.interpark_mypage ->
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.interpark_container, Interpark_fragment_mypage())
                            .commit()

                    R.id.interpark_recent ->
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.interpark_container, Interpark_fragment_recent())
                            .commit()
                }
                true
            }
            selectedItemId = R.id.interpark_home
        }
    }
}