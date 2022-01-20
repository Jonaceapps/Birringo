package com.example.birringo.tutorial

import android.graphics.Color
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.birringo.HomeActivity
import com.example.birringo.R
import kotlinx.android.synthetic.main.login_fragment.view.*
import kotlinx.android.synthetic.main.tutorial_background.*
import kotlinx.android.synthetic.main.tutorial_background.view.*

class BackgroundFragment : Fragment(){
    var homeActivity: HomeActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.tutorial_background, container, false)
        homeActivity = requireActivity() as HomeActivity
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        val sectionsPagerAdapter = SectionsPagerAdapter(homeActivity!!.supportFragmentManager)
        val viewPager: ViewPager = view.view_pager
        viewPager.adapter = sectionsPagerAdapter

        val buttons = view.bottomNavLinearLayout

        for (i in 0 until sectionsPagerAdapter.count) {
            val points = TextView(context)
            points.text = "."
            points.setTextColor(Color.parseColor("#EE9524"))
            points.textSize = 64F

            viewPager.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
                if (i == viewPager.currentItem) {
                    points.setTextColor(Color.parseColor("#EE9524"))
                }else{
                    points.setTextColor(Color.parseColor("#FFE4E4E4"))
                }
            }
            buttons.addView(points)
        }





        return view
    }
}