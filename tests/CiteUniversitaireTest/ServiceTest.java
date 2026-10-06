package CiteUniversitaireTest;

import modeles.Service;

public class ServiceTest {
    
    public static void runTests() {
        Service_Initialisation_EmptyLists();
        ajouterService_ValidInput_AddsToAllLists();
        System.out.println("All tests passed");
    }

    private static void Service_Initialisation_EmptyLists() {
        Service service = new Service();
        assert service != null : "Erreur : L'instance de Service n'a pas pu être créée";
        assert service.getHoraireListe() != null : "Erreur : La liste des horaires n'a pas été initialisée";
        assert service.getServiceMaisonInternational() != null : "Erreur : La liste des services n'a pas été initialisée";
        assert service.getDescription() != null : "Erreur : La liste des descriptions n'a pas été initialisée";
        System.out.println("Service_Initialisation_EmptyLists passed");
    }
    
    private static void ajouterService_ValidInput_AddsToAllLists() {
        Service service = new Service();
        service.ajouterService("09:00-12:00", "Ménage", "Nettoyage des chambres");
        service.ajouterService("14:00-18:00", "Restauration", "Service du dîner");
        
        assert service.getHoraireListe().size() == 2 : "Erreur : La liste des horaires devrait contenir 2 éléments (actuel : " + service.getHoraireListe().size() + ")";
        assert service.getServiceMaisonInternational().size() == 2 : "Erreur : La liste des services devrait contenir 2 éléments (actuel : " + service.getServiceMaisonInternational().size() + ")";
        assert service.getDescription().size() == 2 : "Erreur : La liste des descriptions devrait contenir 2 éléments (actuel : " + service.getDescription().size() + ")";
        assert service.getHoraireListe().get(0).equals("09:00-12:00") : "Erreur : Le premier horaire devrait être '09:00-12:00'";
        assert service.getServiceMaisonInternational().get(0).equals("Ménage") : "Erreur : Le premier service devrait être 'Ménage'";
        assert service.getDescription().get(0).equals("Nettoyage des chambres") : "Erreur : La première description devrait être 'Nettoyage des chambres'";
        System.out.println("ajouterService_ValidInput_AddsToAllLists passed");
    }

    public static void main(String[] args) {
        runTests();
    }
}