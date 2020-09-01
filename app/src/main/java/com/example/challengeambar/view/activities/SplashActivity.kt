package com.example.challengeambar.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeambar.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            showLoginScreen()}, 3000)

    }

    fun showLoginScreen() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}