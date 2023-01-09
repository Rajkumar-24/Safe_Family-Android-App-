package com.example.homians.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.homians.News
import com.example.homians.R



//import com.example.recycleview.News
//import com.example.recycleview.R
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (private val newsList: ArrayList<News>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =newsList[position]
        holder.smallImg.setImageResource(currentItem.smallImg)
        holder.chefName.text = currentItem.chefName
        holder.kitchenName.text = currentItem.kitchenName
        holder.priceName.text = currentItem.priceName
        holder.rateName.text = currentItem.rateName
        holder.bigImg.setImageResource(currentItem.bigImg)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class MyViewHolder(itemView:View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val smallImg :ShapeableImageView = itemView.findViewById(R.id.smallImg)
        val chefName: TextView = itemView.findViewById(R.id.chefName)
        val kitchenName: TextView = itemView.findViewById(R.id.kitchenName)
        val priceName: TextView = itemView.findViewById(R.id.priceName)
        val rateName: TextView = itemView.findViewById(R.id.rateName)
        val bigImg :ShapeableImageView = itemView.findViewById(R.id.bigImg)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }


    }
}