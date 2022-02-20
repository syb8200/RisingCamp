package com.example.risingcamp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2


class CU_home_Fragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //로그인 해주세요 텍스트 클릭
        val login_btn = view.findViewById<TextView>(R.id.cu_login_txt)
        login_btn.setOnClickListener{  view ->
            val intent = Intent(activity, CU_login::class.java)
            startActivity(intent)

            Log.d("Login", "Login_txt selected")
        }


        //뷰페이저2 적용
        val viewPager: ViewPager2 = view.findViewById(R.id.cu_top_banner)
        val viewpagerFragmentAdapter = ViewpagerFragmentAdapter(requireActivity())
        viewPager.adapter = viewpagerFragmentAdapter

        return view

    }

}