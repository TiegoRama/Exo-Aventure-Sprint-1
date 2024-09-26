package item

import jeu.TirageDes
import personnage.Personnage

class Armes (val nom : String ,val description : String, val qualite : Qualite, val type : TypeArmes){

fun calculerdegat(): Int {
    val d20 = TirageDes(1,20).lance()
    var degat = TirageDes(type.nombreDes, type.valeurMax).lance()
    if(d20 >= type.activationCritique ){ degat *= type.multiplicateurcritique}
return degat + qualite.bonusRarete

}
fun utiliser(cible : Personnage) {
}
}