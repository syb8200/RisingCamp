package com.example.risingcamp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.risingcamp.databinding.ActivityCuSettingBinding
import org.w3c.dom.Text


class CU_home_Fragment: Fragment() {

    //sharedpreferences
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        sharedPreferences = requireContext().getSharedPreferences("user", AppCompatActivity.MODE_PRIVATE)

        //[데이터 가져오기]
        //getter로 데이터 가져오기
        val name = sharedPreferences.getString("Name", "ERROR")
        val birth = sharedPreferences.getString("Birth", "ERROR")
        val phone = sharedPreferences.getString("Phone", "ERROR")

        Log.d("homeFragment", "onCreateView()")

        val login_txt = view.findViewById<TextView>(R.id.cu_login_txt)
        val cu_id = view.findViewById<TextView>(R.id.cu_id)
        val cu_id_nim = view.findViewById<TextView>(R.id.cu_id_nim)
        val cu_top_barcode = view.findViewById<ImageView>(R.id.cu_top_barcode)

        login_txt.setOnClickListener{ view->
            val intent = Intent(activity, CU_login::class.java)
            startActivity(intent)
        }


        //왼쪽 카테고리 버튼
        val cu_top_category = view.findViewById<ImageView>(R.id.cu_top_category)
        cu_top_category.setOnClickListener{ view->
            val intent = Intent(activity, CU_setting::class.java)
            startActivity(intent)
        }

        //상단 배너 - 뷰페이저2 적용
        val viewPager: ViewPager2 = view.findViewById(R.id.cu_top_banner)
        val viewpagerFragmentAdapter = ViewpagerFragmentAdapter(requireActivity())
        viewPager.adapter = viewpagerFragmentAdapter

        return view
    }

}