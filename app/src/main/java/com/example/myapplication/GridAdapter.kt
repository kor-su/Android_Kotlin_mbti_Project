package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(private var context: Context?, private var arraylist: ArrayList<GridItem>)
    : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view : View = View.inflate(context, R.layout.activity_mbti_present_first_item, null)

        var icons: ImageView = view.findViewById(R.id.mbti_present_grid_image)
        var name : TextView = view.findViewById(R.id.mbti_present_grid_text)

        var gridItem: GridItem = arraylist.get(p0)

        icons.setImageResource(gridItem.icons!!)
        name.text = gridItem.name

        return  view
    }

    override fun getItem(p0: Int): Any {
        return arraylist.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arraylist.size
    }
}