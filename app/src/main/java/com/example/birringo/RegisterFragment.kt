package com.example.birringo

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_fragment.view.*
import kotlinx.android.synthetic.main.register_fragment.view.*

class RegisterFragment : Fragment(){
    var homeActivity: HomeActivity? = null
    var cambioEstado = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.register_fragment, container, false)
        homeActivity = requireActivity() as HomeActivity
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        view.signin.setOnClickListener {
            homeActivity?.changeFragmentTo(1)
        }

        view.show_hide_pass2.setOnClickListener {
            if (cambioEstado && view.register_password.text.isNotEmpty()) {
                cambioEstado = false
                view.register_password.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                view.show_hide_pass2.setImageResource(R.drawable.hidden_password)
            } else if (!cambioEstado && view.register_password.text.isNotEmpty()){
                cambioEstado = true
                view.register_password.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                view.show_hide_pass2.setImageResource(R.drawable.show_password)
            }
        }

        return view
    }
}