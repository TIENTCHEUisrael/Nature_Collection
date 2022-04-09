package com.example.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.naturecollection.Adapter.PlantItemDecoration
import com.example.naturecollection.Adapter.plant_Adapter
import com.example.naturecollection.MainActivity
import com.example.naturecollection.PlantModel
import com.example.naturecollection.R

class home_fragment(private val context:MainActivity): Fragment(){

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view= inflater?.inflate(R.layout.fragment_home,container,false)//Injecter le home fragment associer


        //creer une liste  qui va stocker ces plantes
        val plantlist= arrayListOf<PlantModel>()

        //Enregistrer une premiere plante dans notre liste
        plantlist.add(
            PlantModel(
                "Pissenlit",
                "Jaune soleil",
                "https://cdn.pixabay.com/photo/2014/05/01/17/51/dandelion-335662_960_720.jpg",
                false
            )
        )
        //Enregistrer une seconde plante dans notre liste
        plantlist.add(
            PlantModel(
                "Rose",
                "ca pique un peu",
                "https://cdn.pixabay.com/photo/2018/05/16/22/27/rose-3407234_960_720.jpg",
                true
            )
        )
        //Enregistrer une troisieme plante dans notre liste
        plantlist.add(
            PlantModel(
                "Castus",
                "ca pique beaucoup",
                "https://cdn.pixabay.com/photo/2016/07/06/20/47/prickly-pear-1501307_960_720.jpg",
                false
            )
        )
        //Enregistrer une quatrieme plante dans notre liste
        plantlist.add(
            PlantModel(
                "Tulipe",
                "c'est beau",
                "https://cdn.pixabay.com/photo/2017/03/13/21/19/tulip-2141216_960_720.jpg",
                false
            )
        )
        //recuperation du premier recycle view

        val horizontalRecycleView=view.findViewById<RecyclerView>(R.id.horizontal_recylcleView)
        horizontalRecycleView.adapter= plant_Adapter(context,plantlist,R.layout.item_horizontal_plant)


        //recuperation du second recycle view

        val verticalRecyclerView=view.findViewById<RecyclerView>(R.id.vertical_recycleView)
        verticalRecyclerView.adapter= plant_Adapter(context,plantlist,R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }
}