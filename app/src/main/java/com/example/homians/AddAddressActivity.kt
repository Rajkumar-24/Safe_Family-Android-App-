package com.example.homians

import android.content.Intent
import android.icu.text.CurrencyPluralInfo.getInstance
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.common.config.GservicesValue.value
import com.google.android.gms.common.data.DataHolder
import com.google.android.material.shape.ShapeAppearancePathProvider.getInstance
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.Collator.getInstance
import kotlin.properties.Delegates

class AddAddressActivity : AppCompatActivity() {
    private lateinit var database  : DatabaseReference
     var count1 by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_add_address)
        val name:EditText = findViewById(R.id.detail_name)
        val address_one:EditText = findViewById(R.id.address_one)
        val address_two:EditText = findViewById(R.id.address_two)
        val phone_no:EditText = findViewById(R.id.phone_no)
        val b_date:EditText = findViewById(R.id.b_date)
        val order_btn:Button = findViewById(R.id.details_btn)
        count1 = 0;
        count1++;
        var count = count1;


        order_btn.setOnClickListener {
            val name1 = name.text.toString()
            val address1 = address_one.text.toString()
            val address2 = address_two.text.toString()
            val phone1 = phone_no.text.toString()
            val date1 = b_date.text.toString()

            database = FirebaseDatabase.getInstance().getReference("User")
            val User = User(name1,address1,address2,phone1,date1,count)
            database.child(name1).setValue(User).addOnSuccessListener {
                Toast.makeText(this, "Address saved successfully", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this, "try again with good internet connection", Toast.LENGTH_SHORT).show()
            }

            btnclick(name,address_one,address_two,phone_no,b_date)
            transfer_data_to_profile(name,address_one,address_two,phone_no,b_date)
        }

    }
    private fun btnclick(name:EditText,address_one:EditText,address_two:EditText,phone_no:EditText,b_date:EditText){
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
                var value = name.text.toString()
//
            Toast.makeText(this, "Address Added Successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PaymentActivity::class.java)
                intent.putExtra("NameP",value)
                startActivity(intent)
                finish()
                
            }
        }
    }
    private fun transfer_data_to_profile(name:EditText,address_one:EditText,address_two:EditText,phone_no:EditText,b_date:EditText){
        val namep = name.text.toString()
        val addressp = address_one.text.toString()
        val address2p = address_two.text.toString()
        val phonep = phone_no.text.toString()
        val dobp = b_date.text.toString()
        val count:Int = 0
//        val value = editText.getText().toString().trim();




    }

}