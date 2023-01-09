package com.example.homians

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class PaymentActivity2 : AppCompatActivity(), PaymentResultListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_payment2)
        val Paybtn: Button = findViewById(R.id.pay_btn)
//        val payAmt: TextView = findViewById(R.id.paymentAmount)


        Paybtn.setOnClickListener {
            makePayment()
        }


    }
    private fun makePayment() {
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Homians ")
            options.put("description","Payment")
            //You can omit the image option to fetch the image from dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("theme.color", "#FEA116");
            options.put("currency","INR");

            options.put("amount","91800")//pass amount in currency subunits



            val prefill = JSONObject()
            prefill.put("email","")
            prefill.put("contact","")

            options.put("prefill",prefill)
            co.open(this,options)
        }catch (e: Exception){
            Toast.makeText(this,"Error in payment: "+ e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this,"success in payment $p0 ", Toast.LENGTH_LONG).show()

    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this,"Error in payment $p1 ", Toast.LENGTH_LONG).show()
    }
}