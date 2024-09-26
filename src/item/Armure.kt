package item
import personnage.Personnage

class Armure(val nom : String , val description : String, val qualite: Qualite, val type: TypeArmure) {
    fun calculProtection():Int{
       return type.BonusProtection + qualite.bonusRarete
    }
    fun utilser(cible : Personnage){

    }
}