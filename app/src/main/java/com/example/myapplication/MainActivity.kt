package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home_mbti_test_btn.setOnClickListener {
            val intent1 = Intent(this, MbtiTestActivity::class.java)
            startActivity(intent1)
            finish()
        }

        home_mbti_present_btn.setOnClickListener {
            val intent2 = Intent(this, MbtiPresentFirstActivty::class.java)
            startActivity(intent2)
            finish()
        }

        home_mbti_information_btn.setOnClickListener {
            val intent3 = Intent(this, TestWebview::class.java)
            startActivity(intent3)
            finish()
        }
    }
}