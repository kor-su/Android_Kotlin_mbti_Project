package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val mbtiList : ArrayList<InfpData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_mbti_present_second_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mbtiList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.CustomViewHolder, position: Int) {
        holder.img.setImageResource(mbtiList.get(position).img)
        holder.name.text = mbtiList.get(position).name
        holder.price.text = mbtiList.get(position).price.toString()
        holder.won.text = mbtiList.get(position).won
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.mbti_present_recyclerview_image) // 이미지
        val name = itemView.findViewById<TextView>(R.id.mbti_present_recyclerview_name) // 이름
        val price = itemView.findViewById<TextView>(R.id.mbti_present_recyclerview_price) // 가격
        val won = itemView.findViewById<TextView>(R.id.mbti_present_recyclerview_priceWon) // 이름
    }


}




