package com.example.birringo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.birringo.tutorial.BackgroundFragment
import com.example.birringo.tutorial.DeliveryFragment
import com.example.birringo.tutorial.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tutorial_background.*

class HomeActivity : AppCompatActivity() {

    var fragmentManager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction? = null
    val loginFragment : LoginFragment = LoginFragment()
    val registerFragment : RegisterFragment = RegisterFragment()
    val backgroundFragment : BackgroundFragment = BackgroundFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Muestra login por defecto, habra que comprobar luego si esta logeado mostrar fragment home y si no login.
        changeFragmentTo(1)


    }
    fun changeFragmentTo(fragment: Int) {
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager?.beginTransaction()

        when (fragment) {

            1 -> {
                fragmentTransaction?.replace(R.id.flFragmentContainer, loginFragment, "Login")
               // mNavigationView.visibility = View.INVISIBLE
            }
            2 -> {
                fragmentTransaction?.replace(R.id.flFragmentContainer, registerFragment, "Register")
                //mNavigationView.visibility = View.VISIBLE
            }
            3 -> {
                fragmentTransaction?.replace(R.id.flFragmentContainer, backgroundFragment, "Tutorial")
            }

            else -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }

        }
        fragmentTransaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }
}