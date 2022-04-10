package com.example.naturecollection.Adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.naturecollection.*

class plant_Adapter(
    val context:MainActivity,
    private val plantlist:List<PlantModel>,
    val layout_id:Int
    ):RecyclerView.Adapter<plant_Adapter.ViewHolder>() {

    //Pour porter la vue (boite pour ranger tout les composant a controller)

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        //importer l'image de la plante
        val plantImage=view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView?=view.findViewById(R.id.name_item)
        val plantDescription:TextView?=view.findViewById(R.id.description_item)
        val starIcon=view.findViewById<ImageView>(R.id.start_icon)

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

        //recuperer le repository
        val repo=PlantRepository()

        //Mise a jour de l'image
        //Utilisation de glide pour recuperer l'image a partir de son lien et l'ajouter a notre composant
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)//chargement d'une image depuis un lien, convertion de l'url de l'image en uri et inclusion dans le composant existant

        //Mise a jour du nom sur la plante
        holder.plantName?.text=currentPlant.name

        //Mise a jour de la description de la plante
        holder.plantDescription?.text=currentPlant.description

        //Verifier si la plante a été liker ou non
        if(currentPlant.liked){
            holder.starIcon.setImageResource(R.drawable.ic_start)
        }
        else{
            holder.starIcon.setImageResource(R.drawable.ic_unstart)
        }

        //rajouter une interaction sur cette etoile
        holder.starIcon.setOnClickListener{
            //Si le bouton est tliker alors on inverse
            currentPlant.liked=!currentPlant.liked
            //Mettre a jour l'object
            repo.updatePlant(currentPlant)
        }

        //Interaction lors du clic d'une plante
        holder.itemView.setOnClickListener{
            //afficher le popup
            PlantPopup(this).show()
        }

    }

    override fun getItemCount(): Int = plantlist.size
}