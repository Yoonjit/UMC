package com.example.week6_hw

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainVPAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when (position){
//            0 -> HomeFragment()
//            1 -> CameraFragment()
//            2 -> SettingFragment()
//            else -> HomeFragment()
                0 -> OneFragment()
                1 -> TwoFragment()
                2 -> ThreeFragment()
                3 -> FourFragment()
                4 -> FiveFragment()
                5 -> SixFragment()
                else -> OneFragment()
        }
    }
}