package CiteUniversitaireTest;

import modeles.RestoU;

public class RestoUTest {
    
    public static void runTests() {
        RestoU_Initialisation_SevenDaysMenu();
        ajouterPlat_ValidDay_AddsDish();
        ajouterPlat_InvalidDay_NoDishAdded();
        getMenu_InvalidDay_ReturnsNull();
        System.out.println("All tests passed");
    }

    private static void RestoU_Initialisation_SevenDaysMenu() {
        RestoU restoU = new RestoU();
        assert restoU != null : "Erreur : L'instance de RestoU n'a pas été créée";
        assert restoU.getMenu(0).size() == 7 : "Erreur : Le menu ne contient pas 7 jours comme attendu";
        System.out.println("RestoU_Initialisation_SevenDaysMenu passed");
    }

    private static void ajouterPlat_ValidDay_AddsDish() {
        RestoU restoU = new RestoU();
        restoU.ajouterPlat(0, "Poulet rôti");
        restoU.ajouterPlat(0, "Purée");
        
        assert restoU.getMenu(0).size() == 2 : "Erreur : Le menu ne contient pas le nombre attendu de plats";
        assert restoU.getMenu(0).contains("Poulet rôti") : "Erreur : Le plat 'Poulet rôti' est manquant dans le menu";
        assert restoU.getMenu(0).contains("Purée") : "Erreur : Le plat 'Purée' est manquant dans le menu";
        System.out.println("ajouterPlat_ValidDay_AddsDish passed");
    }

    private static void ajouterPlat_InvalidDay_NoDishAdded() {
        RestoU restoU = new RestoU();
        restoU.ajouterPlat(-1, "Pizza");
        restoU.ajouterPlat(7, "Poisson");
        
        assert restoU.getMenu(-1) == null : "Erreur : Le menu pour un jour invalide (-1) devrait être null";
        assert restoU.getMenu(7) == null : "Erreur : Le menu pour un jour invalide (7) devrait être null";
        System.out.println("ajouterPlat_InvalidDay_NoDishAdded passed");
    }

    private static void getMenu_InvalidDay_ReturnsNull() {
        RestoU restoU = new RestoU();
        assert restoU.getMenu(-1) == null : "Erreur : Le menu pour un jour invalide (-1) devrait être null";
        assert restoU.getMenu(7) == null : "Erreur : Le menu pour un jour invalide (7) devrait être null";
        System.out.println("getMenu_InvalidDay_ReturnsNull passed");
    }

    public static void main(String[] args) {
        runTests();
    }
}