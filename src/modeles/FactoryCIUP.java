package modeles;

public class FactoryCIUP {
    public void initialiseCIUP() {
        // Création d'étudiants
        Etudiant etudiant1 = new Etudiant("Li", "Wei", "Chine");
        Etudiant etudiant2 = new Etudiant("Wang", "Fang", "Chine");
        Etudiant etudiant3 = new Etudiant("Zhang", "Hua", "Chine");
        Etudiant etudiant4 = new Etudiant("Luca", "Rossi", "Italie");
        Etudiant etudiant5 = new Etudiant("Giulia", "Bianchi", "Italie");
        Etudiant etudiant6 = new Etudiant("Marco", "Verdi", "Italie");
        Etudiant etudiant7 = new Etudiant("Satoshi", "Tanaka", "Japon");
        Etudiant etudiant8 = new Etudiant("Yuki", "Suzuki", "Japon");
        Etudiant etudiant9 = new Etudiant("Haruto", "Yamamoto", "Japon");
        Etudiant etudiant10 = new Etudiant("John", "Smith", "Etats-Unis d'Amérique");
        Etudiant etudiant11 = new Etudiant("Emma", "Johnson", "Etats-Unis d'Amérique");
        Etudiant etudiant12 = new Etudiant("Michael", "Brown", "Etats-Unis d'Amérique");

        // Création des maisons
        Maison maison1 = new Maison("Maison de la Chine", "Chine", "Mme Li", "35.6895, 139.6917", 10);
        Maison maison2 = new Maison("Maison de l'Italie", "Italie", "M. Rossi", "41.9028, 12.4964", 8);
        Maison maison3 = new Maison("Maison du Japon", "Japon", "Mme Tanaka", "35.6895, 139.6917", 12);
        Maison maison4 = new Maison("Maison des Etats-Unis d'Amérique", "Etats-Unis d'Amérique", "M. Smith", "40.7128, -74.0060", 15);

        // Ajout des étudiants dans les maisons
        maison1.ajouterEtudiant(etudiant1);
        maison1.ajouterEtudiant(etudiant2);
        maison1.ajouterEtudiant(etudiant3);
        maison2.ajouterEtudiant(etudiant4);
        maison2.ajouterEtudiant(etudiant5);
        maison2.ajouterEtudiant(etudiant6);
        maison3.ajouterEtudiant(etudiant7);
        maison3.ajouterEtudiant(etudiant8);
        maison3.ajouterEtudiant(etudiant9);
        maison4.ajouterEtudiant(etudiant10);
        maison4.ajouterEtudiant(etudiant11);
        maison4.ajouterEtudiant(etudiant12);

        // Création de la Maison Internationale
        MaisonInternationale maisonInternationale = new MaisonInternationale(null);

        // Création du resto universitaire avec quelques menus
        RestoU restoU = new RestoU();
        restoU.ajouterPlat(0, "Poulet au curry");
        restoU.ajouterPlat(0, "Salade végétarienne");
        restoU.ajouterPlat(1, "Pizza Margherita");

        // Association RestoU à la Maison Internationale
        maisonInternationale.setSonRestoU(restoU);

        // Création du service pour la maison internationale
        Service servicesMaisonInt = new Service();
        servicesMaisonInt.ajouterService("8h-22h", "Bibliothèque", "Accès à des livres et espaces d'étude", "");
        servicesMaisonInt.ajouterService("9h-20h", "Piscine", "Piscine intérieure chauffée", "");

        // Association des services à la maison internationale
        maisonInternationale.setSonService(servicesMaisonInt);
    }
}