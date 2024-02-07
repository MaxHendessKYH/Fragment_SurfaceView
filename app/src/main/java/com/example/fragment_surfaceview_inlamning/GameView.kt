package com.example.fragment_surfaceview_inlamning

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.math.sqrt

class GameView(context: Context?, balll: Ball , balls: MutableList<Ball>, squares: MutableList<Square>) : SurfaceView(context), SurfaceHolder.Callback, Runnable {
    private var thread: Thread? = null
    private var running = false
    lateinit var canvas: Canvas
    var ball: Ball
    lateinit var balls: MutableList<Ball>
    lateinit var squares: MutableList<Square>
    var bounds = Rect()
    var mHolder: SurfaceHolder = holder

    init {
        ball = balll
        this.balls = balls
        this.squares = squares
        if(mHolder != null)
        {
            mHolder?.addCallback(this)
        }
        bounds = holder.surfaceFrame
//        setup()
    }

    fun draw(){
        canvas = mHolder!!.lockCanvas()
        canvas.drawColor(Color.BLUE)
        ball.draw(canvas)
        for(ball in balls)
        {
            ball.draw(canvas)
        }
        for(square in squares)
        {
            square.draw(canvas)
        }

        mHolder!!.unlockCanvasAndPost(canvas)
    }
    private fun setup(color : Int, posX : Float , posY : Float)
    {
//        ball1 = Ball(this.context, color, posX, posY, 20f)
    }
    fun update(){
//        ball1.update()
//        ball2.update()
    }

    fun stop()
    {
        running = false
        thread?.join()
    }
    fun start()
    {
        running = true
        thread = Thread(this)
        thread?.start()
    }
    override fun run()
    {
        draw()
        while (running){
            update()
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder)
    {

    }
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int )
    {
        bounds = Rect(0 , 0 , width , height)
        start()
    }
    override fun surfaceDestroyed(holder: SurfaceHolder)
    {
        stop()
    }
}