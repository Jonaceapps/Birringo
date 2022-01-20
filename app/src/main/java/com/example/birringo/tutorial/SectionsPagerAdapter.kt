package com.example.birringo.tutorial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.birringo.tutorial.DeliveryFragment
import com.example.birringo.tutorial.DiscountFragment
import com.example.birringo.tutorial.OrderFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OrderFragment()
            1 -> DiscountFragment()
            2 -> DeliveryFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
    override fun getCount(): Int {
        return 3
    }
}