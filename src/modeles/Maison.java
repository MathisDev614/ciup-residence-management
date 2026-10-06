package modeles;

import java.util.*;

public class Maison {
	
	//Attribut
    private static int compteur = 0;
    private int idMaison;

    private String nomMaison;
    private String nationaliteMaison;
    private String directeurMaison;
    private String gpsLocalisationMaison;
    private int nbChambresMaison;
    private final int NB_MAX_ETUDIANTS = 30;
    
    private ArrayList<Etudiant> listeEtudiants;
    
    // Constructeur
    public Maison(String nom, String nationalite, String directeur, String gps, int nbChambres) {
        this.idMaison = ++compteur;
        this.nomMaison = nom;
        this.nationaliteMaison = nationalite;
        this.directeurMaison = directeur;
        this.gpsLocalisationMaison = gps;
        this.nbChambresMaison = nbChambres;
        this.listeEtudiants = new ArrayList<>();
    }
    public Maison(String localisationGPS) {

        this.gpsLocalisationMaison = localisationGPS;

    }

    // Getters and Setters
    public int getIdMaison() {
        return idMaison;
    }

    public String getNomMaison() {
        return nomMaison;
    }

    public String getNationaliteMaison() {
        return nationaliteMaison;
    }

    public String getDirecteurMaison() {
        return directeurMaison;
    }

    public String getGpsLocalisationMaison() {
        return gpsLocalisationMaison;
    }

    public int getNbChambresMaison() {
        return nbChambresMaison;
    }

    public int getNB_MAX_ETUDIANTS() {
        return NB_MAX_ETUDIANTS;
    }

    public ArrayList<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }

    public void setNationaliteMaison(String nationaliteMaison) {
        this.nationaliteMaison = nationaliteMaison;
    }

    public void setDirecteurMaison(String directeurMaison) {
        this.directeurMaison = directeurMaison;
    }

    public void setGpsLocalisationMaison(String gpsLocalisationMaison) {
        this.gpsLocalisationMaison = gpsLocalisationMaison;
    }

    // Ajouter un étudiant
    public boolean ajouterEtudiant(Etudiant e) {
        if (listeEtudiants.size() < NB_MAX_ETUDIANTS && nbChambresMaison > 0) {
            listeEtudiants.add(e);
            nbChambresMaison--;
            e.setMaison(this);
            return true;
        } else {
            System.out.println("Aucune chambre disponible dans " + nomMaison);
            return false;
        }
    }

    // Supprimer un étudiant
    public boolean supprimerEtudiant(Etudiant e) {
        if (listeEtudiants.remove(e)) {
            nbChambresMaison++;
            e.setMaison(null);
            return true;
        }
        return false;
    }

    // Affichage des infos
    public void afficher() {
        System.out.println("Maison : " + nomMaison + " (ID " + idMaison + ")");
        System.out.println("Nationalité : " + nationaliteMaison);
        System.out.println("Directeur : " + directeurMaison);
        System.out.println("Localisation GPS : " + gpsLocalisationMaison);
        System.out.println("Chambres disponibles : " + nbChambresMaison);
        System.out.println("Étudiants inscrits :");
        for (Etudiant e : listeEtudiants) {
            System.out.println("- " + e.toString());
        }
    }
}