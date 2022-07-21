package com.example.plantshagbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantshagbook.databinding.ActivityMainBinding
import com.example.plantshagbook.databinding.PlantItemLayoutBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter=PlantAdapter()
    private  val imageIdList=listOf(
            R.drawable.img,
            R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4)
       private var index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            recycle.layoutManager= GridLayoutManager(this@MainActivity,3)
            recycle.adapter=adapter
            btnAdd.setOnClickListener {
                if (index>4) index=0
               val plant=PlantModel(imageIdList[index],"PLANT $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }
}