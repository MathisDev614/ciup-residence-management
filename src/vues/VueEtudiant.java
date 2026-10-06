package vues;

import java.awt.*;
import javax.swing.*;
import modeles.Etudiant;

public class VueEtudiant extends JFrame {

    public VueEtudiant(Etudiant etu) {
        // Configuration de base de la fenêtre
        setTitle("Détails de l'étudiant");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // En-tête avec le nom de l'étudiant
        JPanel header = new JPanel();
        header.setBackground(new Color(200, 230, 255));
        JLabel lblTitre = new JLabel(
            "Étudiant : " + etu.getPrenomEtudiant() + " " + etu.getNomEtudiant(),
            SwingConstants.CENTER
        );
        lblTitre.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitre.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        header.add(lblTitre);
        add(header, BorderLayout.NORTH);

        JButton homeButton = new JButton("🏠");
        header.add(homeButton, BorderLayout.EAST);

        // Corps de la vue : grille des attributs
        JPanel content = new JPanel(new GridLayout(0, 1, 5, 5));
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Affichage de chaque propriété de l'étudiant
        content.add(new JLabel("ID : " + etu.getIdEtudiant()));
        content.add(new JLabel("Prénom : " + etu.getPrenomEtudiant()));
        content.add(new JLabel("Nom : " + etu.getNomEtudiant()));
        content.add(new JLabel("Nationalité : " + etu.getNationaliteEtudiant()));
        content.add(new JLabel("Ancien étudiant : " + (etu.isEstAncienEtudiant() ? "Oui" : "Non")));
        String maison = (etu.getMaison() != null) ? etu.getMaison().toString() : "Aucune";
        content.add(new JLabel("Maison : " + maison));

        add(content, BorderLayout.CENTER);

        // Footer avec bouton de retour
        JPanel footer = new JPanel();
        JButton ajouterEtudiant = new JButton("AJOUTER UN ETUDIANT");
        ajouterEtudiant.setBackground(new Color(240, 240, 240));
        footer.add(ajouterEtudiant);
        add(footer, BorderLayout.SOUTH);

        // Affichage final
        setVisible(true);
    }

    // Test de la vue
    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant("Li", "Wei", "Chine");
        new VueEtudiant(etudiant1);
    }
}
