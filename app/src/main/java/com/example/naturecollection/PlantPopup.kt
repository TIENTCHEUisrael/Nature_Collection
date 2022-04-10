package com.example.naturecollection

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import com.example.naturecollection.Adapter.plant_Adapter

class PlantPopup(private val adapter: plant_Adapter): Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Enlever le titre sur la popup
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //Injecter le layout creer
        setContentView(R.layout.popup_plant_details)
    }
}