package com.example.homians

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.homians.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_my_account)
        val my_profile:TextView = findViewById(R.id.myp)
        val backarrow1:ImageView = findViewById(R.id.backarrow1)
        val blog:TextView = findViewById(R.id.blog)

        my_profile.setOnClickListener {
            val intent = Intent(this,profile::class.java)
            startActivity(intent)

        }
        backarrow1.setOnClickListener {
            super.onBackPressed()
        }
        blog.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.homians.com/")
            startActivity(intent)
        }
    }
}