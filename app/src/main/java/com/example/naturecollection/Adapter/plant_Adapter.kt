package com.example.naturecollection.Adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.naturecollection.MainActivity
import com.example.naturecollection.PlantModel
import com.example.naturecollection.R

class plant_Adapter(
    private val context:MainActivity,
    private val plantlist:List<PlantModel>,
    val layout_id:Int
    ):RecyclerView.Adapter<plant_Adapter.ViewHolder>() {

    //Pour porter la vue (boite pour ranger tout les composant a controller)

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        //importer l'image de la plante
        val plantImage=view.findViewById<ImageView>(R.id.image_item)
        val plantName=view.findViewById<TextView>(R.id.name_item)
        val plantDescription=view.findViewById<TextView>(R.id.description_item)

    }

    //Injecter un layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
            .from(parent.context)//prendre le contexte
            .inflate(layout_id,parent,false)//injecter l'element



        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //recuperer les information de la plante
        val currentPlant=plantlist[position]

        //Utilisation de glide pour recuperer l'image a partir de son lien et l'ajouter a notre composant
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)//chargement d'une image depuis un lien, convertion de l'url de l'image en uri et inclusion dans le composant existant



    }

    override fun getItemCount(): Int = plantlist.size
}