package com.example.framelayoutdemo3

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.FrameLayout
import java.util.*

class MainActivity : Activity() {
    //初始化变量,帧布局
    var frame: FrameLayout? = null

    //自定义一个用于定时更新UI界面的handler类对象
    var handler: Handler = object : Handler() {
        var i = 0
        override fun handleMessage(msg: Message) {
            //判断信息是否为本应用发出的
            if (msg.what == 0x123) {
                i++
                move(i % 8)
            }
            super.handleMessage(msg)
        }
    }

    //定义走路时切换图片的方法
    fun move(i: Int) {
        val a = resources.getDrawable(R.drawable.s_1)
        val b = resources.getDrawable(R.drawable.s_2)
        val c = resources.getDrawable(R.drawable.s_3)
        val d = resources.getDrawable(R.drawable.s_4)
        val e = resources.getDrawable(R.drawable.s_5)
        val f = resources.getDrawable(R.drawable.s_6)
        val g = resources.getDrawable(R.drawable.s_7)
        val h = resources.getDrawable(R.drawable.s_8)
        when (i) {
            0 -> frame!!.foreground = a
            1 -> frame!!.foreground = b
            2 -> frame!!.foreground = c
            3 -> frame!!.foreground = d
            4 -> frame!!.foreground = e
            5 -> frame!!.foreground = f
            6 -> frame!!.foreground = g
            7 -> frame!!.foreground = h
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        frame = findViewById<View>(R.id.myframe) as FrameLayout
        //定义一个定时器对象,定时发送信息给handler
        Timer().schedule(object : TimerTask() {
            override fun run() {
                //发送一条空信息来通知系统改变前景图片
                handler.sendEmptyMessage(0x123)
            }
        }, 0, 170)
    }
}