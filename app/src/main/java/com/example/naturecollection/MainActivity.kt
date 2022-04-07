package com.example.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.naturecollection.fragments.home_fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //injection du fragment dans notre boite(fragment_container)
        val transaction=supportFragmentManager.beginTransaction()//manipulation de la dynamique des fragment
        transaction.replace(R.id.fragment_container,home_fragment())//remplacement du contenu du fragment
        transaction.addToBackStack(null)//pas avoir de retour sur ce composant
        transaction.commit()//Envoyer l'echangement
    }
}