package com.example.birringo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_fragment.view.*
import kotlinx.android.synthetic.main.register_fragment.view.*

class RegisterFragment : Fragment(){
    var homeActivity: HomeActivity? = null

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

        return view
    }
}