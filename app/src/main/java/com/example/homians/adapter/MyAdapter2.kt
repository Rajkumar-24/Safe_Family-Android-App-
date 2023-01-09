package com.example.bottomnavbar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.homians.NewsH
import com.example.homians.R


import com.google.android.material.imageview.ShapeableImageView


class MyAdapter2 (private val newsList2: ArrayList<NewsH>):
    RecyclerView.Adapter<MyAdapter2.MyViewHolder2>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {
        val itemView2 = LayoutInflater.from(parent.context).inflate(R.layout.list_item_ver,parent,false)
        return MyViewHolder2(itemView2)
    }

    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {
        val currentItem2 =newsList2[position]
        holder.titleImage2.setImageResource(currentItem2.titleImage2)

    }

    override fun getItemCount(): Int {
        return newsList2.size
    }

    class MyViewHolder2(itemView: View):RecyclerView.ViewHolder(itemView) {
        val titleImage2: ShapeableImageView = itemView.findViewById(R.id.title_image2)

    }

}