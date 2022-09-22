package com.example.text

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class MeziView(context: Context?) : View(context) {
    var bitmapX = 0f
    var bitmapY = 200f

    //重写View类的onDraw()方法
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.s_jump)
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint)
        if (bitmap.isRecycled) {
            bitmap.recycle()
        }
    }
}