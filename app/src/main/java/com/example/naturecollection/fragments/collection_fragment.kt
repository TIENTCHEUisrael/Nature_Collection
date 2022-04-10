package com.example.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naturecollection.Adapter.PlantItemDecoration
import com.example.naturecollection.Adapter.plant_Adapter
import com.example.naturecollection.MainActivity
import com.example.naturecollection.PlantRepository.Singleton.plantlist
import com.example.naturecollection.R

class collection_fragment(
    private val context:MainActivity
): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater?.inflate(R.layout.fragment_collection,container,false)

        //recuperer la recycle view
        val collectionRecycleView=view.findViewById<RecyclerView>(R.id.collection_recycle_list)
        collectionRecycleView.adapter=plant_Adapter(context,plantlist.filter { it.liked },R.layout.item_vertical_plant)
        collectionRecycleView.layoutManager=LinearLayoutManager(context)
        collectionRecycleView.addItemDecoration(PlantItemDecoration())

        return view

    }
}