package com.example.homians

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homians.adapter.MyAdapter3
import java.text.FieldPosition

class SearchBar : AppCompatActivity() {
    private lateinit var newRecycleview3: RecyclerView
    private lateinit var newArratList3: ArrayList<NewsSearchbar>
    lateinit var imageId3 :Array<Int>
    lateinit var kitchenName : Array<String>
    lateinit var money3: Array<String>
    private lateinit var  tempArrayList:ArrayList<NewsSearchbar>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_bar)

        imageId3 = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.e

        )
        kitchenName = arrayOf(
            "Alpha Kitchen",
            "Beta Kitchen",
            "Gamma Kitchen"
        )
        money3 = arrayOf(
            "900₹",
            "930₹",
            "890₹"
        )
        newRecycleview3 = findViewById(R.id.recyclesearch)
        newRecycleview3.layoutManager = LinearLayoutManager(this)
        newRecycleview3.setHasFixedSize(true)

        newArratList3 = arrayListOf<NewsSearchbar>()
        tempArrayList = arrayListOf<NewsSearchbar>()
        getUserdata()

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
////        menuInflater.inflate(R.menu.menu)
//    }

    private fun getUserdata() {
        for(i in imageId3.indices){
            val news1 = NewsSearchbar(imageId3[i],kitchenName[i], money3[i])
            newArratList3.add(news1)
        }

        tempArrayList.addAll(newArratList3)

        var adapter3 = MyAdapter3(newArratList3)
        newRecycleview3.adapter = adapter3
        adapter3.setOnItemClickListener(object : MyAdapter3.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@SearchBar, "hello", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SearchBar,SearchShow::class.java)
                intent.putExtra("KitchenName",newArratList3[position].Kitchenname)
                intent.putExtra("imagename",newArratList3[position].Bigimg)

                startActivity(intent)

            }

        })
    }
}