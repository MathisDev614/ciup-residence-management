package CiteUniversitaireTest;

import modeles.Etudiant;

public class EtudiantTest {

    public static void main(String[] args) {
        testToString_RetourAttendu();
        System.out.println("Tous les tests de Etudiant passés.");
    }

    private static void testToString_RetourAttendu() {
        Etudiant e = new Etudiant("Anna", "Lemoine", "Française");
        String attendu = "Anna Lemoine (Française)";
        assert e.toString().equals(attendu) : "Échec : toString ne retourne pas le format attendu.";

        System.out.println("testToString_RetourAttendu passé.");
    }
}
