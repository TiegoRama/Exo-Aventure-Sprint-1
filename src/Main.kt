import item.*
import jeu.Jeu
import personnage.Personnage
import java.lang.reflect.Type

//Créattion des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

//TODO Sprint 1 Mission 2A et 2B Création des types d'armes/armures
//Création des types d'armes
val typeepeelongue = TypeArmes(1,8,2,19)
val typehache = TypeArmes(1,8,3,20)
val typedague = TypeArmes(1,4,3,18)
val typebaton = TypeArmes(1,6,2,20)
val typelance= TypeArmes(1,8,3,20)
val typearbaletelegere = TypeArmes(1,8,2,19)
val typeepeecourte = TypeArmes(1,6,3,19)
val typemarteauguerre = TypeArmes (1,8,3,20)
val typearclong = TypeArmes(1,8,3,20)
// Création d'armes
val arclong = Armes("Arc long", "Arc long",qualiteCommun,typearclong)
val arbaletelegere = Armes("Arbalète légère","Arbalète pas très lourde",qualiteCommun, typearbaletelegere)
val epeecourte = Armes("Epée courte","Une petite épée", qualiteCommun,typeepeecourte)
val marteauguerre = Armes("Marteau de guerre","Gros marteau", qualiteCommun,typemarteauguerre)
val lance = Armes ("Lance","Lance",qualiteCommun,typelance)
val hache = Armes("Hache","Hache à 2 mains", qualiteCommun,typehache)
val dague = Armes("Dague", "Dague", qualiteCommun,typedague)
val baton = Armes("Bâton", "Long bâton", qualiteCommun,typebaton)
val epeelongue = Armes("Epee Longue","Longue épée", qualiteCommun,typeepeelongue)
// Création des types armures

val typeRembourer = TypeArmure("Rembouré",1)
val typeCuir = TypeArmure("Cuir",2)
val typeCuirCloute = TypeArmure("CuirCloute",3)
val typeChemiseAChaine  = TypeArmure("Chemise à chaine",4)
val typePectoral = TypeArmure("Pectoral",5)
val typeCotteDeMailles = TypeArmure("Cotte de mailles",6)
val Rembourer = Armure("Armure Rembourer","Rembourer",qualiteCommun,typeRembourer)
val Cuir = Armure("Armure en cuir","C'est du cuir",qualiteCommun,typeCuir)
val CuirCloute = Armure("Armure en cuir clouté","C'est du cuir avec des clous",qualiteRare,typeCuirCloute)
val ChemiseAChaine = Armure("Chemise a fleur","Magnifique chemise avec des fleurs",qualiteLegendaire,typeChemiseAChaine)
val Pectoral = Armure("Torse nue","La bonne bagarre",qualiteEpic,typePectoral)
val CotteDeMaille = Armure("Cotte de maille","Armure portée par les chevalier",qualiteEpic,typeCotteDeMailles)

)
//TODO Sprint 2 : Création de sorts

fun main(args: Array<String>) {
    // TODO Intemission 4 : Création des items ( armes, armures potions, bombes )

    //Création des monstres
    val gobelin = Personnage(
        "Gob le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6)
    val kobold = Personnage(
        "Kob le Kobold",
        pointDeVie = 10,
        pointDeVieMax = 10,
        attaque = 4,
        defense = 4,
        vitesse = 11,
        endurance = 6)
    val troll = Personnage(
        "Groll",
        pointDeVie = 80,
        pointDeVieMax = 80,
        attaque = 15,
        defense = 10,
        vitesse = 5,
        endurance = 10)
    val orc = Personnage(
        "Morc",
        pointDeVie = 40,
        pointDeVieMax = 40,
        attaque = 10,
        defense = 9,
        vitesse = 6,
        endurance = 8)


    // TODO Intermission 1 : Ajouter d'autres monstres

    //TODO On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin,kobold,troll,orc))
    //Lancement du jeu
    jeu.lancerCombat()
}