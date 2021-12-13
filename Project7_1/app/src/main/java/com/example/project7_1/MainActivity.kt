package com.example.project7_1

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "토스트 연습"

        var button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            var tMsg = Toast.makeText(applicationContext, "토스트 연습", Toast.LENGTH_SHORT)

            var display = (getSystemService(Context.WINDOW_SERVICE) as
                    WindowManager).defaultDisplay
            var xOffset = (Math.random() * display.width).toInt()
            var yOffset = (Math.random() * display.height).toInt()

            tMsg.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)
            tMsg.show()
        }
    }

}