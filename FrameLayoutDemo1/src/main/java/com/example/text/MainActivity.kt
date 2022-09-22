package com.example.text

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnTouchListener
import android.widget.FrameLayout

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frame = findViewById<View>(R.id.mylayout) as FrameLayout
        val mezi = MeziView(this@MainActivity)

        //为我们的萌妹子添加触摸事件监听器
        mezi.setOnTouchListener(OnTouchListener { view, event -> //设置妹子显示的位置
            mezi.bitmapX = event.x - 150
            mezi.bitmapY = event.y - 150
            mezi.invalidate()
            true
        })
        frame.addView(mezi)
    }
}