package com.example.homians

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment

import com.example.homians.fragment.AccountFragment
import com.example.homians.fragment.HomeFragment
import com.example.homians.fragment.StatusFragment
import com.example.homians.fragment.historyFragment

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val accountfragment = AccountFragment()
    private val homeFragment = HomeFragment()
    private val statusFragment = StatusFragment()
    private val HistoryFrag = historyFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        val nav:BottomNavigationView= findViewById(R.id.bottom_navigation)
        currentfrag(homeFragment)
        nav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->{
                    currentfrag(homeFragment)
                    Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_account->{
                    currentfrag(accountfragment)
                    Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_status->{
                    currentfrag(statusFragment)
                    Toast.makeText(this, "Status", Toast.LENGTH_SHORT).show()

                }
                R.id.nav_history->{
                    currentfrag(HistoryFrag)
                    Toast.makeText(this, "history", Toast.LENGTH_SHORT).show()

                }
            }
            true
        }




    }

    private fun currentfrag(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
    }


}