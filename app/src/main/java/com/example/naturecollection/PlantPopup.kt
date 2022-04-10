package com.example.naturecollection

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
        //Insertion des methodes pour les modifications du popup
        setupCompoments()
        setupCloseButton()
        setupDeleteButton()
        setupStarButton()
    }

    private fun updatestar(button: ImageView){
        if(currentPlant.liked){
            button.setImageResource(R.drawable.ic_start)
        }
        else{
            button.setImageResource(R.drawable.ic_unstart)
        }
    }

    private fun setupStarButton() {
        //recuperer
        val starButton=findViewById<ImageView>(R.id.star_button)

        updatestar(starButton)
        //interaction

        starButton.setOnClickListener{
            currentPlant.liked=!currentPlant.liked
            val repo=PlantRepository()
            repo.updatePlant(currentPlant)
            updatestar(starButton)
        }
    }

    private fun setupDeleteButton() {
        findViewById<ImageView>(R.id.delete_button).setOnClickListener{
            //supprimer la plante de la base en appelant la methode de ...repository
            val repo=PlantRepository()
             repo.deletePlant(currentPlant)
            dismiss()
            Toast.makeText(adapter.context, "Donnée supprimer", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupCloseButton() {
        //recuperation
        findViewById<ImageView>(R.id.close_button).setOnClickListener{
            //fermer la fenetre
            dismiss()
        }
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