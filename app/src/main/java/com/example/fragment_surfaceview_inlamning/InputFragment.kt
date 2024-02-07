package com.example.fragment_surfaceview_inlamning

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.lang.Exception
import com.example.fragment_surfaceview_inlamning.databinding.FragmentInputBinding
import com.example.fragment_surfaceview_inlamning.databinding.FragmentOutputBinding

public class InputFragment : Fragment() {
   var listener: FragmentCommunicationListener? = null

    lateinit var binding: FragmentInputBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
           listener = context as FragmentCommunicationListener
            println("successfully implemented listener interface")
        } catch (e: Exception){
            println("not implemented listener interface")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
           sendValues()
        }
    }
 private fun sendValues()
 {
     val x = binding.etX.text.toString()
     val y = binding.etY.text.toString()
     val color = binding.etColor.text.toString()
     listener?.onXChanged(x.toFloat())
     listener?.onYChanged(y.toFloat())
     listener?.onColorChanged(color.toInt())
 }
    override fun onDetach() {
        super.onDetach()
       listener = null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):View? {
//      val view = inflater.inflate(R.layout.fragment_input, container, false)
        binding = FragmentInputBinding.inflate(layoutInflater, container, false)
        return binding.root

        return view
    }
    interface FragmentCommunicationListener{
        fun onXChanged(x : Float)
        fun onYChanged(y : Float)
        fun onColorChanged(color : Int)
    }

}