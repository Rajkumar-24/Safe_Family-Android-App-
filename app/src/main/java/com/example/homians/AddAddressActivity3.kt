package com.example.homians

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddAddressActivity3 : AppCompatActivity() {
    private lateinit var database  : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_add_address3)
        val name: EditText = findViewById(R.id.detail_name)
        val address_one: EditText = findViewById(R.id.address_one)
        val address_two: EditText = findViewById(R.id.address_two)
        val phone_no: EditText = findViewById(R.id.phone_no)
        val b_date: EditText = findViewById(R.id.b_date)
        val order_btn: Button = findViewById(R.id.details_btn)
        order_btn.setOnClickListener {
            val name1 = name.text.toString()
            val address1 = address_one.text.toString()
            val address2 = address_two.text.toString()
            val phone1 = phone_no.text.toString()
            val date1 = b_date.text.toString()
            database = FirebaseDatabase.getInstance().getReference("User")
            val User = User(name1,address1,address2,phone1,date1)
            database.child(name1).setValue(User).addOnSuccessListener {
                Toast.makeText(this, "Address saved successfully", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "try again with good internet connection", Toast.LENGTH_SHORT).show()
            }

            btnclick(name,address_one,phone_no,b_date)
        }

    }
    private fun btnclick(name: EditText, address_one: EditText, phone_no: EditText, b_date: EditText){
        when{
            TextUtils.isEmpty(name.text.toString().trim{ it <=' ' })->{
                Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show()
            }
            TextUtils.isEmpty(address_one.text.toString().trim{ it <=' ' })->{
                Toast.makeText(this, "Please enter Address", Toast.LENGTH_SHORT).show()
            }
            TextUtils.isEmpty(phone_no.text.toString().trim{ it <=' ' })->{
                Toast.makeText(this, "Please enter Phone Number", Toast.LENGTH_SHORT).show()
            }
            TextUtils.isEmpty(b_date.text.toString().trim{ it <=' ' })->{
                Toast.makeText(this, "Please enter date of birth", Toast.LENGTH_SHORT).show()
            }

            else->{
                Toast.makeText(this, "Address Added Successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PaymentActivity3::class.java)
                startActivity(intent)
                finish()

            }
        }
    }

}