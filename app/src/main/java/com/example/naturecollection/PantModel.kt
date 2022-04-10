package com.example.naturecollection


//Class pour l'enregistrement de nouvelle plante de l'application
class PlantModel(
    val id:String="plant0",
    val name:String="Tulip",
    val description:String="Petite description",
    val imageUrl:String="http://graven.yt/plante.jpg",
    val grow:String="faible",
    val water:String="Moyenne",
    var liked:Boolean=false
)