package com.example.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.naturecollection.fragments.collection_fragment
import com.example.naturecollection.fragments.home_fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Charger le planRepository
        val repo=PlantRepository()

        //Mettre a jour les données
        repo.updateData{
            //Une fois que la liste est charger la on viens faire le reste ci dessous. C'est a sa que sert le callback
            //injection du fragment dans notre boite(fragment_container)
            val transaction=supportFragmentManager.beginTransaction()//manipulation de la dynamique des fragment
            transaction.replace(R.id.fragment_container,collection_fragment(this))//remplacement du contenu du fragment
            transaction.addToBackStack(null)//pas avoir de retour sur ce composant
            transaction.commit()//Envoyer l'echangement
        }


    }
}