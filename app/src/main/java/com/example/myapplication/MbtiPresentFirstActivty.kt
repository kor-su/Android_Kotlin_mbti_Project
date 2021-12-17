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
    private var gridviewAdapter : GridviewAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_mbti_present_first)

        gridView = findViewById(R.id.mbti_present_grid_view)
        arrayList = setDataList()
        gridviewAdapter = GridviewAdapter(applicationContext, arrayList!!)
        gridView?.adapter = gridviewAdapter

    }

    private fun setDataList(): ArrayList<GridItem> {
        var arrayList: ArrayList<GridItem> = ArrayList()

        arrayList.add(GridItem(R.drawable. , "INFP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "ENFP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "ESFJ")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "ISFJ")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "ISFP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "ESFP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "INTP")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "INFJ")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "ENFJ")) // drawable 폴더에 저장한 이미지명 넣기
        arrayList.add(GridItem(R.drawable. , "ENTP")) // drawable 폴더에 저장한 이미지명 넣기

        return arrayList
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var intent = Intent(this, MbtiPresentSecondActivity::class.java)
        startActivity()
    }

}