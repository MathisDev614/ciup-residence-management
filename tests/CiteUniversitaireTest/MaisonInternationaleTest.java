package CiteUniversitaireTest;

import modeles.MaisonInternationale;
import modeles.RestoU;
import modeles.Service;

public class MaisonInternationaleTest {

    public static void runTests() {
        creationMaisonInternationale_AssigneAttributsCorrectement();
        gettersSetters_ModificationFonctionnelle();
        afficherInfos_AfficheSansErreur();
        System.out.println("All MaisonInternationale tests passed");
    }

    private static void creationMaisonInternationale_AssigneAttributsCorrectement() {
        MaisonInternationale maison = new MaisonInternationale("48.8210, 2.3390");

        assert maison.getLocalisationGPS().equals("48.8210, 2.3390") : "Localisation GPS incorrecte";
        assert maison.getSonRestoU() != null : "RestoU non initialisé";
        assert maison.getSonService() != null : "Service non initialisé";
        System.out.println("creationMaisonInternationale_AssigneAttributsCorrectement passed");
    }

    private static void gettersSetters_ModificationFonctionnelle() {
        MaisonInternationale maison = new MaisonInternationale("48.8210, 2.3390");
        RestoU nouveauResto = new RestoU();
        Service nouveauService = new Service();

        maison.setSonRestoU(nouveauResto);
        maison.setSonService(nouveauService);
        maison.setLocalisationGPS("48.0000, 2.0000");

        assert maison.getSonRestoU() == nouveauResto : "setSonRestoU ne fonctionne pas";
        assert maison.getSonService() == nouveauService : "setSonService ne fonctionne pas";
        assert maison.getLocalisationGPS().equals("48.0000, 2.0000") : "setLocalisationGPS ne fonctionne pas";
        System.out.println("gettersSetters_ModificationFonctionnelle passed");
    }

    private static void afficherInfos_AfficheSansErreur() {
        MaisonInternationale maison = new MaisonInternationale("48.8210, 2.3390");

        try {
            maison.afficherInfos();
            System.out.println("afficherInfos_AfficheSansErreur passed");
        } catch (Exception e) {
            assert false : "Erreur lors de l'affichage des informations";
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
