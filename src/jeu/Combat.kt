package jeu
import kotlin.random.Random
import personnage.Personnage

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")
       //TODO Mission 1.2
        val actions = mapOf(
            1 to "Attaquer",
            2 to "Passer"
        )
        println("Choisir une action :")
       for(uneAction in actions){
           println(" ${uneAction.key} ${uneAction.value}")
       }
        var choixValide = false
        while(!choixValide) {
            var choix = readln()
            if(choix == "1") {
                choixValide = true
                this.jeu.joueur.attaque(monstre)
            }
            else if (choix == "2") {
                choixValide = true
                println("vous passez votre tour")
            }
            else {
                println("Mauvaise saisie !!!")


            }
        }



        this.jeu.joueur.attaque(monstre)
        println("\u001b[0m")
    }

    // Méthode pour simuler un tour de combat du monstre
    /**
     * On rend les attaques des ennemies de manière aléatoire en important le module Random
     *
     */
    fun tourDeMonstre() {
        println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
        //TODO Mission 1.3
        var random = (1..100).random()
        if (random<=70){
        this.monstre.attaque(this.jeu.joueur)}


        println("\u001b[0m")
    }

    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}