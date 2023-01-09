package com.example.homians

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SearchShow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_show)

        val kitname: TextView = findViewById(R.id.kname)
        val picname :ImageView = findViewById(R.id.iname)
        val bundel :Bundle? = intent.extras
        val KitchenName = bundel!!.getString("KitchenName")
        val imagename = bundel.getInt("imagename")

        kitname.text = KitchenName
        picname.setImageResource(imagename)
    }
}