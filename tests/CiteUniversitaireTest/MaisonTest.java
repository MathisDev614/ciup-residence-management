package CiteUniversitaireTest;

import modeles.*;

public class MaisonTest {

    public static void main(String[] args) {
        testAjouterEtudiant_AvecChambre_EtudiantAjoute();
        testAjouterEtudiant_SansChambre_EtudiantNonAjoute();
        testSupprimerEtudiant_EtudiantPresent_EtudiantSupprime();
        testSupprimerEtudiant_EtudiantAbsent_EchecSuppression();
        System.out.println("Tous les tests de Maison passés.");
    }

    private static void testAjouterEtudiant_AvecChambre_EtudiantAjoute() {
        Maison maison = new Maison("Maison test", "France", "Mme Test", "48.85, 2.35", 2);
        Etudiant e = new Etudiant("Jean", "Dupont", "Français");

        boolean resultat = maison.ajouterEtudiant(e);
        assert resultat : "Échec : l'étudiant aurait dû être ajouté.";
        assert maison.getListeEtudiants().contains(e) : "Échec : l'étudiant ne figure pas dans la liste.";
        assert e.getMaison() == maison : "Échec : la maison n’a pas été associée à l’étudiant.";

        System.out.println("testAjouterEtudiant_AvecChambre_EtudiantAjoute passé.");
    }

    private static void testAjouterEtudiant_SansChambre_EtudiantNonAjoute() {
        Maison maison = new Maison("Maison pleine", "France", "Mme Test", "48.85, 2.35", 0);
        Etudiant e = new Etudiant("Lucie", "Martin", "Française");

        boolean resultat = maison.ajouterEtudiant(e);
        assert !resultat : "Échec : l'étudiant n’aurait pas dû être ajouté.";
        assert !maison.getListeEtudiants().contains(e) : "Échec : l'étudiant figure dans la liste alors qu’il ne devrait pas.";

        System.out.println("testAjouterEtudiant_SansChambre_EtudiantNonAjoute passé.");
    }

    private static void testSupprimerEtudiant_EtudiantPresent_EtudiantSupprime() {
        Maison maison = new Maison("Maison test", "France", "Mme Test", "48.85, 2.35", 1);
        Etudiant e = new Etudiant("Claire", "Dubois", "Française");

        maison.ajouterEtudiant(e);
        boolean resultat = maison.supprimerEtudiant(e);
        assert resultat : "Échec : suppression impossible alors que l’étudiant est présent.";
        assert !maison.getListeEtudiants().contains(e) : "Échec : l'étudiant figure toujours dans la liste.";
        assert e.getMaison() == null : "Échec : la maison est encore liée à l’étudiant.";

        System.out.println("testSupprimerEtudiant_EtudiantPresent_EtudiantSupprime passé.");
    }

    private static void testSupprimerEtudiant_EtudiantAbsent_EchecSuppression() {
        Maison maison = new Maison("Maison test", "France", "Mme Test", "48.85, 2.35", 1);
        Etudiant e = new Etudiant("Lucas", "Durand", "Français");

        boolean resultat = maison.supprimerEtudiant(e);
        assert !resultat : "Échec : suppression réussie alors que l’étudiant n’est pas dans la maison.";

        System.out.println("testSupprimerEtudiant_EtudiantAbsent_EchecSuppression passé.");
    }
}
