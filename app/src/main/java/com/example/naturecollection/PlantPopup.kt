package com.example.naturecollection

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.naturecollection.Adapter.plant_Adapter

class PlantPopup(private val adapter: plant_Adapter,
                 private val currentPlant: PlantModel): Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Enlever le titre sur la popup
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //Injecter le layout creer
        setContentView(R.layout.popup_plant_details)
    }

    private fun setupCompoments(){
        //Actualiser l'image de la plante
        val plantImage=findViewById<ImageView>(R.id.image_item)
        Glide.with(adapter.context).load(Uri.parse(currentPlant.imageUrl)).into(plantImage)

        //Actualiser le nom de la plante
        findViewById<TextView>(R.id.popup_plant_name).text=currentPlant.name

        //Actuallizer la description de la plante
        findViewById<TextView>(R.id.popup_plant_description_subtitle).text=currentPlant.description

        //Actualiser la croissance de la plante
        findViewById<TextView>(R.id.popup_plant_grow_subtitle).text=currentPlant.grow

        //Actualiser la consommation d'eau
        findViewById<TextView>(R.id.popup_plant_water_subtitle).text=currentPlant.water
    }
}