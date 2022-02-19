package com.example.risingcamp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.risingcamp.databinding.ActivityCuBottomNavBinding

class CU_bottom_nav : AppCompatActivity() {

    // 뷰바인딩 사용
    private lateinit var binding: ActivityCuBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuBottomNavBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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


    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.cu_container, CU_home_Fragment())
            .commit()
    }

}