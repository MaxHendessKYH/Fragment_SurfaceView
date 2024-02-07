package com.example.fragment_surfaceview_inlamning

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

class Square (context : Context?, var color: Int, var left: Int, var right: Int, var top: Int , var bottom: Int, var size: Float){
    var paint = Paint()
    private val rectPaint = Paint().apply {
//        color = Color.RED
        style = Paint.Style.FILL
    }
    init{
        when(color)
        {
            1 -> color = Color.RED
            2 -> color = Color.GREEN
            3 -> color = Color.YELLOW
            4 -> color = Color.BLACK
            5 -> color = Color.GRAY
            6 -> color = Color.MAGENTA
            7 -> color = Color.WHITE
            8 -> color = Color.DKGRAY
            9 -> color = Color.LTGRAY
        }
        paint.color = color
    }
    fun draw(canvas: Canvas?)
    {
        val r = Rect(left , top , right, bottom)
        canvas?.drawRect(r, paint)
    }
}