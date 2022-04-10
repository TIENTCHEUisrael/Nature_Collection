package com.example.naturecollection

import com.example.naturecollection.PlantRepository.Singleton.databaseref
import com.example.naturecollection.PlantRepository.Singleton.plantlist
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import javax.security.auth.callback.Callback

class PlantRepository {

    object Singleton{
        //valeur pour se connecter a la reference "plants"
        val databaseref=FirebaseDatabase.getInstance().getReference("plants")

        //Creation d'une liste qui va contenir
        val plantlist= arrayListOf<PlantModel>()
    }

    fun updateData(callback: ()-> Unit){
        //Prendre les donnée recuperer dans la database reference et les affecter a notre liste de plante qu'on a plus haut
        databaseref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                //retirer les anciennes
                plantlist.clear()
                //recolter la liste
                for(ds in snapshot.children){
                    //construire une nouvelle plante par rappart a ce qu'on aura recolter
                    val plant=ds.getValue(PlantModel::class.java)

                    //verifier que la plante n'est pas null
                    if(plant!=null){
                        //Ajouter la plante a la liste
                        plantlist.add(plant)
                    }
                }
                //Actionner le callback
                callback()
            }

            override fun onCancelled(error: DatabaseError) {
                //Au cas ou il ne trouve pas de recolte
            }

        })
    }

    //Mettre a jour l'object
    fun updatePlant(plant:PlantModel){

    }


}