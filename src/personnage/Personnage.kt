package personnage

import item.*

class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    val inventaire: MutableList<Item> = mutableListOf(),
    var armePrincipale: Armes,
    var armure: Armure,
) {
/**
 * Agit sur l'armure et la défense
 * @return la defense après l'ajout de l'amure
 * */

     fun calculeDefense():Int{
         //TODO Mission 4.2
        this.defense = (this.armure.calculProtection() + this.defense)/2
        return this.defense
     }
    /**
     * @param armure on prend l'armure du personnage
     * On affiche le nom de l'armure équipé
     */
    fun equipeArmure(armure: Armure){
        for(item in inventaire){
            if(item == armure){
                this.armure = armure
                println("${this.nom} equipe ${this.armure.nom}")
            }
        }
    }

    /**
     * @param arme on prend l'arme du personnage
     * On affiche le nom de l'arme équipé
     */
    fun equipeArme(arme: Armes){
    for (item in inventaire){
        this.armePrincipale = arme
        println("${this.nom} equipe ${this.armePrincipale.nom}")
    }
}
     // Méthode pour attaquer un adversaire
    /**
     * @param adversaire Cible de l'attaque.
     * @param arme Arme utilisée pour l'attaque
     * Agit sur les points de vie de la cible et affiche le résultat dans le terminal.
     */
    fun attaque(adversaire: Personnage,arme: Armes) {
        //TODO Mission 4.1
         if(this.armePrincipale == arme){this.attaque += arme.calculerdegat()}
        var degats= this.attaque/2
        degats -= adversaire.defense
        adversaire.pointDeVie-=degats
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
    }

    /**
     * @return Vrai si y'a une potion, faux si il n'y a pas de potion
     */
    fun avoirPotion(): Boolean{
        for(item in this.inventaire){
            if(item is Potion) {
            return true
            }
        }
    return false

    }

    /**
     * @return True si y'a une bombe, False si y'a pas de bombe
     */
    fun avoirBombe(): Boolean{
        for(item in this.inventaire){
            if(item is Bombe) {
                return true
            }

        }
        return false
    }

    fun boirePotion(){
        if(avoirPotion()){
            var potions:MutableList<Potion> = mutableListOf()
            for(item in this.inventaire){
                if(item is Potion){
                    potions.add(item)
                }
            }
            println("Liste des potions")
            var i=0
            for (unePotion in potions){
                println("$i => ${unePotion.nom}")
            }
            println("Saisir la potion")
            var indexPotion= readln().toInt()
            var laPotion=potions[indexPotion]
            laPotion.utiliser(this)
        }

    }


    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


}