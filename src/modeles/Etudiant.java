package modeles;

public class Etudiant {

	//Attributs
    private static int compteur = 0;
    private int idEtudiant;

    private String prenomEtudiant;
    private String nomEtudiant;
    private String nationaliteEtudiant;
    private boolean estAncienEtudiant;

    private Maison maison;

    // Constructeur
    public Etudiant(String prenom, String nom, String nationalite) {
        this.idEtudiant = ++compteur;
        this.prenomEtudiant = prenom;
        this.nomEtudiant = nom;
        this.nationaliteEtudiant = nationalite;
        this.estAncienEtudiant = false;
        this.maison = null;
    }

    // Getters and Setters
    public int getIdEtudiant() {
        return idEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public String getNationaliteEtudiant() {
        return nationaliteEtudiant;
    }

    public boolean isEstAncienEtudiant() {
        return estAncienEtudiant;
    }

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public void setEstAncienEtudiant(boolean estAncien) {
        this.estAncienEtudiant = estAncien;
    }

    @Override
    public String toString() {
        return prenomEtudiant + " " + nomEtudiant + " (" + nationaliteEtudiant + ")";
    }
}