package modeles;

import java.util.ArrayList;

public class CIUP {

    private final ArrayList<Maison> listeMaisons;
    private MaisonInternationale maisonInternationale;

    public CIUP() {
        this.listeMaisons = new ArrayList<>();
    }

    public void initialiser() {
        FactoryCIUP factory = new FactoryCIUP();
        factory.initialiseCIUP();

        // Création de la Maison Internationale
        maisonInternationale = new MaisonInternationale("48.8210, 2.3390");

        // Ajout à la liste globale
        listeMaisons.add(maisonInternationale);
    }

    public void ajouterMaison(Maison maison) {
        listeMaisons.add(maison);
    }

    public void afficherToutesLesMaisons() {
        for (Maison m : listeMaisons) {
            m.afficher();
        }
    }

    public void afficherMaisonInternationale() {
        if (maisonInternationale != null) {
            maisonInternationale.afficherInfos();
        } else {
            System.out.println("Maison Internationale non initialisée.");
        }
    }
    
}
