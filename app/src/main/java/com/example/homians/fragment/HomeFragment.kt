package com.example.homians.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.example.bottomnavbar.adapter.MyAdapter2
import com.example.homians.*
import com.example.homians.adapter.MyAdapter



class HomeFragment : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var smallImg:Array<Int>
    lateinit var bigImg:Array<Int>
    lateinit var chefName:Array<String>
    lateinit var kitchenName:Array<String>
    lateinit var priceName:Array<String>
    lateinit var rateName:Array<String>
    private lateinit var newRecyclerView2: RecyclerView
    private lateinit var newArrayList2: ArrayList<NewsH>
    lateinit var imageid2:Array<Int>
    lateinit var heading2:Array<String>
//    lateinit var  chef_img1:ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        rvVertical(view)
        rvHorizontal(view)
        val chef_img1:ImageView = view.findViewById(R.id.chef_img1)
        val chef_img2:ImageView = view.findViewById(R.id.chef_img2)
        val chef_img3:ImageView = view.findViewById(R.id.chef_img3)
        val corner_chef_img:ImageView = view.findViewById(R.id.corner_chef_img)
        val SearchBarr:ImageView = view.findViewById(R.id.searchbarclick)
        SearchBarr.setOnClickListener {
            val intent = Intent(activity, SearchBar::class.java)
            activity?.startActivity(intent)
        }
        chef_img1.setOnClickListener {
            val intent = Intent(activity, AlphaKitchen::class.java)
            activity?.startActivity(intent)
        }
        chef_img2.setOnClickListener {
            val intent = Intent(activity,BetaKitchen::class.java)
            activity?.startActivity(intent)
        }
        chef_img3.setOnClickListener {
            val intent = Intent(activity,catalogue_sceen::class.java)
            activity?.startActivity(intent)
        }
        corner_chef_img.setOnClickListener {
            val intent = Intent(activity,MyAccount::class.java)
            activity?.startActivity(intent)
        }


        return view
    }

    private fun rvVertical(view: View) {
        smallImg = arrayOf(
            R.drawable.a,

            R.drawable.c,
            R.drawable.d,

        )
        chefName = arrayOf(
            "Vijay Singh",
            "Jatin kumar",
            "Gomsi Singh",
        )
        kitchenName = arrayOf(
            "Alpha",

            "Beta",
            "Gamma",
        )
        priceName = arrayOf(
            "900₹",

            "930₹",
            "890₹",
        )
        rateName = arrayOf(
            "✨4.5",

            "✨4.9",
            "✨4.1",
        )
        bigImg = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,

            )
        newRecyclerView = view.findViewById(R.id.recycleView)
        newRecyclerView.layoutManager = LinearLayoutManager(view.context,)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<News>()
        getUserdata()

    }
    private fun rvHorizontal(view: View) {
        imageid2 = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,

        )
        heading2 = arrayOf(
            "this is one(Horizontal)",
            "this is two(Horizontal)",
            "this is three(Horizontal)",
            "this is four(Horizontal)",
        )
        newRecyclerView2 = view.findViewById(R.id.recycleView2)
        newRecyclerView2.layoutManager = GridLayoutManager(view.context,1,
            GridLayoutManager.HORIZONTAL,false)
        newRecyclerView2.setHasFixedSize(true)
        newArrayList2 = arrayListOf<NewsH>()
        getUserdata2()

    }

    private fun getUserdata2() {
        for (i in imageid2.indices){
            val newsh = NewsH(imageid2[i], heading2[i])
            newArrayList2.add(newsh)
        }
        newRecyclerView2.adapter = MyAdapter2(newArrayList2)
    }

    private fun getUserdata() {
        for (i in smallImg.indices){
            val news = News(smallImg[i], chefName[i],kitchenName[i],priceName[i],rateName[i],bigImg[i])
            newArrayList.add(news)
        }
        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()///
                val intent = Intent(activity, KitchenActivity2::class.java)
                intent.putExtra("ChefName",newArrayList[position].chefName)
                intent.putExtra("Kitname",newArrayList[position].kitchenName)
                intent.putExtra("Ratename",newArrayList[position].rateName)
                startActivity(intent)



            }

        })

    }


}