package com.example.birringo

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val backgroundAnimation = AnimationUtils.loadAnimation(this, R.anim.backgrond_animation)
        backgroundImage.startAnimation(backgroundAnimation)
        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_animation)
        logo_img.startAnimation(logoAnimation)

        val homeIntent = Intent(this, HomeActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(homeIntent)
            finish()
        }, 7000)

    }
}