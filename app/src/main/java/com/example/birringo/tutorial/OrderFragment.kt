package com.example.birringo.tutorial


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.birringo.R
import kotlinx.android.synthetic.main.fragment_delivery.view.*
import kotlinx.android.synthetic.main.fragment_delivery.view.titleTextView
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.android.synthetic.main.fragment_order.view.*


class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_order, container, false)
        view.titleTextView.text = "DELIVERY"

        return view
    }
}