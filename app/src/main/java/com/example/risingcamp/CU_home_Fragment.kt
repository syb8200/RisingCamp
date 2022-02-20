package com.example.risingcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStateManagerControl
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2


class CU_home_Fragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val viewPager: ViewPager2 = view.findViewById(R.id.cu_top_banner)
        val viewpagerFragmentAdapter = ViewpagerFragmentAdapter(this.requireActivity())
        viewPager.adapter = viewpagerFragmentAdapter

        return view

    }

}