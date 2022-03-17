package com.example.risingcamp.week5_hw

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewpagerFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    val fragmentList = listOf<Fragment>(Interpark_fragment_top_banner1(), Interpark_fragment_top_banner2(), Interpark_fragment_top_banner3(), Interpark_fragment_top_banner4(), Interpark_fragment_top_banner5())
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}