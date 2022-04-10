package com.example.naturecollection.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.naturecollection.MainActivity
import com.example.naturecollection.R

class add_plant_fragment(private val context:MainActivity): Fragment() {

    private var uploadedImage:ImageView?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater?.inflate(R.layout.fragment_add_plant,container,false)

        //recuperation de uploadedImage pour lui affecter l'ancienne imaage

        uploadedImage=view.findViewById(R.id.preview_image)

        //recuperation du button pour charger l'image
        val pickupImagebutton=view.findViewById<Button>(R.id.upload_button)

        //Evenement lorsqu'on clique dessus on affiche les images du telephone
        pickupImagebutton.setOnClickListener { pickupImage() }
        return view
    }

    private fun pickupImage() {
        val intent= Intent()
        intent.type="image/"
        intent.action=Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),47)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==47 && resultCode==Activity.RESULT_OK){

            //Verifier si les donnée qui ont ete recuperer sont nulles
            if(data==null || data.data==null){
                return
            }
            //recuperer l'image
            val selectedImage=data.data

            //mettre a jour l'image
            uploadedImage?.setImageURI(selectedImage)

        }
    }
}