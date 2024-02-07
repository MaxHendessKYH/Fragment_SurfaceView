package com.example.fragment_surfaceview_inlamning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.fragment_surfaceview_inlamning.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), InputFragment.FragmentCommunicationListener {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.offscreenPageLimit = 1

        binding.btnFirst.setOnClickListener {
            binding.viewPager.currentItem--
        }

        binding.btnSecond.setOnClickListener {
            if (binding.viewPager.currentItem >= 2) {
                binding.viewPager.currentItem = 0
            } else binding.viewPager.currentItem++
        }
    }
    //#region Interface override
    override fun onXChanged(x : Float)
    {
        val fragment = supportFragmentManager.findFragmentByTag("f1") as OutputFragment?
        fragment?.updateX(x)
    }
    override fun onYChanged(y : Float)
    {
        val fragment = supportFragmentManager.findFragmentByTag("f1") as OutputFragment?
        fragment?.updateY(y)
    }
    override fun onColorChanged(color: Int) {
        val fragment = supportFragmentManager.findFragmentByTag("f1") as OutputFragment?
        fragment?.updateColor(color)
    }
//#endregion
}
