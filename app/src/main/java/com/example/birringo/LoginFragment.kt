package com.example.birringo

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*

class LoginFragment : Fragment(){
    var homeActivity: HomeActivity? = null
    var cambioEstado = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.login_fragment, container, false)
        homeActivity = requireActivity() as HomeActivity
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        view.signup.setOnClickListener {
            homeActivity?.changeFragmentTo(2)
        }

        view.show_hide_pass.setOnClickListener {
            if (cambioEstado && view.login_password.text.isNotEmpty()) {
                cambioEstado = false
                view.login_password.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                view.show_hide_pass.setImageResource(R.drawable.hidden_password)
            } else if (!cambioEstado && view.login_password.text.isNotEmpty()){
                cambioEstado = true
                view.login_password.transformationMethod =
                   PasswordTransformationMethod.getInstance()
                view.show_hide_pass.setImageResource(R.drawable.show_password)
            }
        }


        return view
    }
}