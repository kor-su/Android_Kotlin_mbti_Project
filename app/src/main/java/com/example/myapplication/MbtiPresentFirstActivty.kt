package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MbtiPresentFirstActivty : AppCompatActivity() , AdapterView.OnItemClickListener {

    private var gridView:GridView ? = null
    private var arrayList:ArrayList<GridItem> ? = null
    private var gridAdapter : GridAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mbti_present_first)

        gridView = findViewById(R.id.mbti_present_grid_view)
        arrayList = setDataList()
        gridAdapter = GridAdapter(applicationContext, arrayList!!)
        gridView?.adapter = gridAdapter
        gridView?.onItemClickListener = this

    }

    private fun setDataList(): ArrayList<GridItem> {
        var arrayList: ArrayList<GridItem> = ArrayList()

        arrayList.add(GridItem(R.drawable.infp , "INFP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.enfp , "ENFP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.esfj , "ESFJ")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.isfj , "ISFJ")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.isfp , "ISFP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.esfp , "ESFP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.infp , "INTP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.infj , "INFJ")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.enfj , "ENFJ")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable.entp , "ENTP")) // drawable 폴더에 저장한 이미지명 넣기

        return arrayList
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        var gridItem : GridItem = arrayList!!.get(p2)

        if (p2 == 0) {
            var intent = Intent(this, MbtiPresentSecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}