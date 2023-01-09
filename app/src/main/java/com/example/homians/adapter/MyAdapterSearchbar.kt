package com.example.homians.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.adapter.MyAdapter2
import com.example.homians.NewsH
import com.example.homians.NewsSearchbar
import com.example.homians.R
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter3 (private val newsList3: ArrayList<NewsSearchbar>):
    RecyclerView.Adapter<MyAdapter3.MyViewHolder3>() {

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder3 {
 val itemView3 = LayoutInflater.from(parent.context).inflate(R.layout.list_item_searachbar,parent,false)
        return MyViewHolder3(itemView3,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder3, position: Int) {
        val currentItem = newsList3[position]
        holder.titleImage3.setImageResource(currentItem.Bigimg)
        holder.kitchenName.text = currentItem.Kitchenname
        holder.moneyy.text = currentItem.money


    }

    override fun getItemCount(): Int {
        return newsList3.size
    }

    class MyViewHolder3(itemView: View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView) {
        val titleImage3: ImageView = itemView.findViewById(R.id.kitchenimg)
        val kitchenName:TextView = itemView.findViewById(R.id.kitchenName11)
        val moneyy:TextView = itemView.findViewById(R.id.description11)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }

        }

    }



}