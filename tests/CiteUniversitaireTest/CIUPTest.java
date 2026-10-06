package CiteUniversitaireTest;

import modeles.CIUP;
import modeles.Maison;
import modeles.MaisonInternationale;

public class CIUPTest {

    public static void runTests() {
        CIUP_Initialisation_AjouteMaisonInternationale();
        ajouterMaison_AjouteUneMaison();
        afficherMaisonInternationale_NonInitialisee();
        System.out.println("All CIUP tests passed");
    }

    private static void CIUP_Initialisation_AjouteMaisonInternationale() {
        CIUP ciup = new CIUP();
        ciup.initialiser();
        assert ciup != null : "Erreur : CIUP non créée";
        System.out.println("CIUP_Initialisation_AjouteMaisonInternationale passed");
    }

    private static void ajouterMaison_AjouteUneMaison() {
        CIUP ciup = new CIUP();
        Maison maisonTest = new Maison("48.8380, 2.3450");
        ciup.ajouterMaison(maisonTest);

        try {
            ciup.afficherToutesLesMaisons();
            System.out.println("ajouterMaison_AjouteUneMaison passed");
        } catch (Exception e) {
            assert false : "Erreur lors de l'affichage des maisons après ajout";
        }
    }

    private static void afficherMaisonInternationale_NonInitialisee() {
        CIUP ciup = new CIUP();

        try {
            ciup.afficherMaisonInternationale();
            System.out.println("afficherMaisonInternationale_NonInitialisee passed");
        } catch (Exception e) {
            assert false : "Erreur lors de l'affichage d'une maison internationale non initialisée";
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
