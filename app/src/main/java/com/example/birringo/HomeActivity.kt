package com.example.birringo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class HomeActivity : AppCompatActivity() {

    var fragmentManager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction? = null
    val loginFragment : LoginFragment = LoginFragment()
    val registerFragment : RegisterFragment = RegisterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

            else -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }

        }
        fragmentTransaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }
}