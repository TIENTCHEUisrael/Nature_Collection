package com.example.naturecollection.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.naturecollection.MainActivity
import com.example.naturecollection.PlantModel
import com.example.naturecollection.R

class plant_Adapter(
    private val context:MainActivity,
    private val plantlist:List<PlantModel>,
    val layout_id:Int):RecyclerView.Adapter<plant_Adapter.ViewHolder>() {

    //Pour porter la vue (boite pour ranger tout les composant a controller)

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        //importer l'image de la plante
        val plantImage=view.findViewById<ImageView>(R.id.image_item)
    }

    //Injecter un layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
            .from(parent.context)//prendre le contexte
            .inflate(layout_id,parent,false)//injecter l'element


        //Utilisation de glide pour recuperer l'image a partir de son lien et l'ajouter a notre composant
        Glide.with(context)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //recuperer les information de la plante
        val currentPlant=plantlist[position]


    }

    override fun getItemCount(): Int = plantlist.size
}