package CiteUniversitaireTest;

import modeles.FactoryCIUP;

public class FactoryCIUPTest {

    public static void runTests() {
        initialiseCIUP_ExecuteSansErreur();
        System.out.println("All FactoryCIUP tests passed");
    }

    private static void initialiseCIUP_ExecuteSansErreur() {
        FactoryCIUP factory = new FactoryCIUP();

        try {
            factory.initialiseCIUP();
            System.out.println("initialiseCIUP_ExecuteSansErreur passed");
        } catch (Exception e) {
            assert false : "La méthode initialiseCIUP a levé une exception : " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
