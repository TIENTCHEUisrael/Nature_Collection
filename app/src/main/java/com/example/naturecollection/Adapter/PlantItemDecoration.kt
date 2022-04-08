package com.example.naturecollection.Adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


//pour dire commbien on  veut d'espace
class PlantItemDecoration :RecyclerView.ItemDecoration(){
    //rajouter un decalage
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        //je vais faire le decalage par le bas
        outRect.bottom=20
    }
}