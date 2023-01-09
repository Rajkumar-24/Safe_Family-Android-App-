package com.example.homians

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.homians.R
import com.example.homians.fragment.ImgFragment
import com.example.homians.fragment.MenuFragment
import com.example.homians.fragment.review


class KitchenActivity2 : AppCompatActivity() {
    private  var reviewFragment = review()
    private val menuFragment = MenuFragment()
    private val imgFragment = ImgFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_kitchen2)
        val menutv: TextView = findViewById(R.id.menutv)
        val reviewtv: TextView = findViewById(R.id.reviewtv)
        val imgtv: TextView = findViewById(R.id.imagestv)
        val sub_btn:Button = findViewById(R.id.sub_btn)
        val cname:TextView = findViewById(R.id.chefName)
        val kiname:TextView = findViewById(R.id.kitname)
        val rate:TextView = findViewById(R.id.rating)

        //
        currentfrag(menuFragment)
        val bundel :Bundle? = intent.extras
        val chefname = bundel!!.getString("ChefName")
        val name2 = bundel!!.getString("Kitname")
        val rate1 = bundel!!.getString("Ratename")
        cname.text = chefname
        kiname.text = name2
        rate.text = rate1


        sub_btn.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        menutv.setOnClickListener {
            currentfrag(menuFragment)
        }
        reviewtv.setOnClickListener {
            currentfrag(reviewFragment)
        }
        imgtv.setOnClickListener {
            currentfrag(imgFragment)
        }
    }
    private fun currentfrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentcont,fragment)
            commit()
        }
    }
}