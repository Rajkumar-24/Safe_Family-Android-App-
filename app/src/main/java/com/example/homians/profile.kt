package com.example.homians

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.homians.databinding.ActivityProfileBinding
import com.google.firebase.database.DatabaseReference

class profile : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)
        val backarrow2:ImageView = findViewById(R.id.backarrow2)
        val profile_btn:Button = findViewById(R.id.profile_btn)
        val profile_switch:Switch = findViewById(R.id.profile_switch)

        val nn = intent.getStringArrayExtra("NameP")
        val email:EditText = findViewById(R.id.profile_reg_id_tv)
        val name:TextView = findViewById(R.id.profile_top_name_tv)
        val address1:EditText = findViewById(R.id.profile_organization_tv)
        val address2:EditText = findViewById(R.id.profile_emp_id_no_tv)
        var mobile:Any? = findViewById(R.id.profile_mobile_no_tv)
        val dob_profile:EditText = findViewById(R.id.bob_profile)





        profile_switch.setOnClickListener {
            profile_btn.setVisibility(View.VISIBLE)
        }
        backarrow2.setOnClickListener {
            super.onBackPressed()
        }

    }
}