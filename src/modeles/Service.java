package modeles;

import java.util.ArrayList;

public class Service {

	private ArrayList<String> _horaireListe;
	private ArrayList<String> _serviceMaisonInternational;
	private ArrayList<String> _description;
	private ArrayList<String> _imagePath;

	// Constructeur
	public Service() {
		_horaireListe = new ArrayList<>();
		_serviceMaisonInternational = new ArrayList<>();
		_description = new ArrayList<>();
		_imagePath = new ArrayList<>();
	}

	public ArrayList<String> getHoraireListe() {
		return this._horaireListe;
	}

	public void setHoraireListe(ArrayList<String> _horaireListe) {
		this._horaireListe = _horaireListe;
	}

	public ArrayList<String> getServiceMaisonInternational() {
		return this._serviceMaisonInternational;
	}

	public void setServiceMaisonInternational(ArrayList<String> _serviceMaisonInternational) {
		this._serviceMaisonInternational = _serviceMaisonInternational;
	}

	public ArrayList<String> getDescription() {
		return this._description;
	}

	public void setDescription(ArrayList<String> _description) {
		this._description = _description;
	}

	public ArrayList<String> getImagePath() {
		return this._imagePath;
	}
	
	public void setImagePath(ArrayList<String> _imagePath) {
		this._imagePath = _imagePath;
	}
    
    // Méthode pour ajouter un service (horaire, nom et description)
    public void ajouterService(String horaire, String service, String description, String imagePath) {
        _horaireListe.add(horaire);
        _serviceMaisonInternational.add(service);
        _description.add(description);
		_imagePath.add(imagePath);
    }
    
    // Affiche tous les services dispo
    public void afficherServices() {
        for (int i = 0; i < _horaireListe.size(); i++) {
            System.out.println("Service " + (i + 1) + ": " 
                + _serviceMaisonInternational.get(i) 
                + " - Horaire: " + _horaireListe.get(i) 
                + " - Description: " + _description.get(i));
        }
    }
}