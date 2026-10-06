package modeles;

public class MaisonInternationale extends Maison {

    private RestoU _sonRestoU;
    private Service _sonService;
    private String _localisationGPS;

    public MaisonInternationale(String localisationGPS) {
        super(localisationGPS); // Call the superclass constructor
        this._localisationGPS = localisationGPS;
        this._sonRestoU = new RestoU();
        this._sonService = new Service();
    }

    public RestoU getSonRestoU() {
        return _sonRestoU;
    }

    public void setSonRestoU(RestoU sonRestoU) {
        this._sonRestoU = sonRestoU;
    }

    public Service getSonService() {
        return _sonService;
    }

    public void setSonService(Service sonService) {
        this._sonService = sonService;
    }

    public String getLocalisationGPS() {
        return _localisationGPS;
    }

    public void setLocalisationGPS(String localisationGPS) {
        this._localisationGPS = localisationGPS;
    }

    public void afficherInfos() {
        System.out.println("Maison Internationale - Localisation : " + _localisationGPS);
        System.out.println("--- RestoU ---");
        _sonRestoU.afficherMenu();
        System.out.println("--- Services ---");
        _sonService.afficherServices();
    }
} 
