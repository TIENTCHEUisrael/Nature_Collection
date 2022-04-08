package com.example.naturecollection.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.naturecollection.R

class plant_Adapter:RecyclerView.Adapter<plant_Adapter.ViewHolder>() {
    //Pour porter la vue (boite pour ranger tout les composant a controler)
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        //importer la plante
        val plantImage=view.findViewById<ImageView>(R.id.image_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_horizontal_plant,parent,false)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}