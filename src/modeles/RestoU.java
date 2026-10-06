package modeles;

import java.util.ArrayList;

public class RestoU {

    MaisonInternationale propose;
    Maison sert;
    private ArrayList<ArrayList<String>> _menu;
    private ArrayList<String> _nom_jour_semaine;

    // Constructeur
    public RestoU() {
        _menu = new ArrayList<>();
        _nom_jour_semaine = new ArrayList<>(7);

        for (int i = 0; i < 7; i++) {
            _menu.add(new ArrayList<String>());
        }
    }
    
    // Ajouter un plat
    public void ajouterPlat(int jour, String plat) {
        if (jour >= 0 && jour < _menu.size()) {
            _menu.get(jour).add(plat);
        }
    }
    
    // Récupère le menu d'un jour
    public ArrayList<String> getMenu(int jour) {
        if (jour >= 0 && jour < _menu.size()) {
            return _menu.get(jour);
        }
        return null;
    }
    
    // Affiche le menu
    public void afficherMenu() {
        String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        for (int i = 0; i < _menu.size(); i++) {
            System.out.println("Menu pour " + jours[i] + " : " + _menu.get(i));
        }
    }
    
    // Getters et setters
    public MaisonInternationale get_propose() {
        return propose;
    }

    public void set_propose(MaisonInternationale propose) {
        this.propose = propose;
    }

    public Maison get_sert() {
        return sert;
    }

    public void set_sert(Maison sert) {
        this.sert = sert;
    }

    public ArrayList<String> get_nomJourSemaine() {
        return _nom_jour_semaine;
    }

    public void set_nomJourSemaine(ArrayList<String> _nom_jour_semaine) {
        this._nom_jour_semaine = _nom_jour_semaine;
    }
}