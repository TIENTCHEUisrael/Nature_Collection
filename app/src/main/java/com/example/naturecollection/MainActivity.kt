package com.example.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.naturecollection.fragments.add_plant_fragment
import com.example.naturecollection.fragments.collection_fragment
import com.example.naturecollection.fragments.home_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       loadfragment(home_fragment(this))

    //importer le bottomNavigationView
        val navigationView=findViewById<BottomNavigationView>(R.id.navigation_view)
            navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_page->{
                    loadfragment(home_fragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.collection_page->{
                    loadfragment(collection_fragment(this))
                    return@setOnNavigationItemSelectedListener true

                }
                R.id.add_plant_page->{
                    loadfragment(add_plant_fragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                else ->false
            }
        }
    }

    private fun loadfragment(fragment: Fragment) {
        //Charger le planRepository
        val repo=PlantRepository()

        //Mettre a jour les données
        repo.updateData{
            //Une fois que la liste est charger la on viens faire le reste ci dessous. C'est a sa que sert le callback
            //injection du fragment dans notre boite(fragment_container)
            val transaction=supportFragmentManager.beginTransaction()//manipulation de la dynamique des fragment
            transaction.replace(R.id.fragment_container,fragment)//remplacement du contenu du fragment
            transaction.addToBackStack(null)//pas avoir de retour sur ce composant
            transaction.commit()//Envoyer l'echangement
        }

    }
}