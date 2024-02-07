package com.example.fragment_surfaceview_inlamning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment_surfaceview_inlamning.databinding.FragmentOutputBinding
import kotlin.random.Random
class OutputFragment : Fragment() {
    lateinit var binding: FragmentOutputBinding
    var x: Float = 0f
    var y: Float = 0f
    var color: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
//#region Draw
    fun geneateBall(): Ball
    {
        val randomNumber = Random.nextInt(1, 4)
        val randomColor = Random.nextInt(1, 9)
        val randomX = Random.nextInt(100, 201)
        val randomY = Random.nextInt(100, 201)
        when (randomNumber) {
            1 -> {
                val newBall = Ball(context, randomColor, x + randomX, y, 50f)
                x += randomX
                y += randomY
                return newBall
            }

            2 -> {
                val newBall = Ball(context, randomColor, x - randomX, y, 50f)
                x -= randomX
                y -= randomY
                return newBall
            }

            3 -> {
                val newBall = Ball(context, randomColor, x, y + randomY, 50f)
                x += randomX
                y += randomY
                return newBall
            }

            4 -> {
                val newBall = Ball(context, randomColor, x, y - randomY, 50f)
                x -= randomX
                y -= randomY
                return newBall
            }

            else ->{
                val newBall = Ball(context, randomColor, x, y - randomY, 50f)
                x -= randomX
                y -= randomY
                return newBall
            }
        }
    }
    fun drawSquare():Square
    {
        val randomNumber = Random.nextInt(1, 4)
        val randomColor = Random.nextInt(1, 9)
        val randomWidth = Random.nextInt(100, 201)
        val randomHeight = Random.nextInt(100, 201)
        val newSquare = Square(context, randomColor, x.toInt() - randomWidth,
            (x.toInt() - randomWidth) + randomWidth,x.toInt() - randomHeight,(x.toInt() - randomHeight) + randomHeight,50f)

        return newSquare
    }
    fun draw()
    {
        val ball = Ball(context, color, x , y, 50f)
        var balls = mutableListOf<Ball>()
        var squares = mutableListOf<Square>()
        for (i in 0..5) {
                val randomShape = Random.nextInt(1, 2)
              balls.add(geneateBall())
               squares.add(drawSquare())
        }
        val gameView = GameView(context , ball, balls, squares)
        val container = binding.root
        container.addView(gameView)
    }
    //#endregion
    //#region updateValues
    fun updateX(x  : Float)
    {
       this.x = x
        draw()
    }
    fun updateY(y : Float)
    {
        this.y = y
    }
    fun updateColor(color : Int)
    {
       this.color = color
    }
    //#endregion
}