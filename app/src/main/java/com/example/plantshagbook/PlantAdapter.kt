package com.example.plantshagbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plantshagbook.databinding.PlantItemLayoutBinding

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {
    private var planList= mutableListOf<PlantModel>()

    class PlantViewHolder(item: View):RecyclerView.ViewHolder(item){
        val binding=PlantItemLayoutBinding.bind(item)
        fun bind(plant: PlantModel)= with(binding){
            imgPlant.setImageResource(plant.imageId)
            tvTitle.text=plant.title
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {

val view=LayoutInflater.from(parent.context).inflate(R.layout.plant_item_layout,parent,false)
        return PlantViewHolder(view)

    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {

 holder.bind(planList[position])

    }

    override fun getItemCount(): Int {
           return planList.size   }


   fun setData( list: MutableList<PlantModel>){
       this.planList = list
       notifyDataSetChanged()
}

    fun getData():MutableList<PlantModel>{
    return planList

}

}