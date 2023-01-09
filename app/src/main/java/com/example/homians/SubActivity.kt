package com.example.homians

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView


class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_sub)

        val order_btn1:Button = findViewById(R.id.order_btn)
        val order_btn2:Button = findViewById(R.id.order_btn2)
        val order_btn3:Button = findViewById(R.id.order_btn3)
        val monthly_cv:CardView = findViewById(R.id.monthly_cv)
        monthly_cv.setOnClickListener {
            val intent  = Intent(this,AddAddressActivity::class.java)
            startActivity(intent)
            finish()
        }
        order_btn1.setOnClickListener {

            val intent = Intent(this, AddAddressActivity::class.java)
            startActivity(intent)
        }
        order_btn2.setOnClickListener {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AddAddressActivity2::class.java)
            startActivity(intent)
        }
        order_btn3.setOnClickListener {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AddAddressActivity3::class.java)
            startActivity(intent)
        }


    }
}