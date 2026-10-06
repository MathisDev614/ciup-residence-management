package vues;

import java.awt.*;
import javax.swing.*;
import modeles.Maison;

public class VueMaisons extends JFrame {
    private JButton homeButton;
    private JButton ajouterMaison;
    public JButton getBoutonHome() {
        return homeButton;
    }

    public JButton getBoutonAjouterMaison() {
        return ajouterMaison;
    }
    

    public VueMaisons() {
        setTitle("Liste des Maisons");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        


        // En-tête
        JPanel header = new JPanel();
        header.setBackground(new Color(180, 255, 200));
        header.setLayout(new BorderLayout());

        JLabel logo = new JLabel("CITE INTERNATIONALE UNIVERSITAIRE DE PARIS");
        logo.setFont(new Font("Arial", Font.BOLD, 25));
        logo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        header.add(logo, BorderLayout.WEST);

        JTextField searchBar = new JTextField("");
        header.add(searchBar, BorderLayout.CENTER);

        homeButton = new JButton("🏠");
        header.add(homeButton, BorderLayout.EAST);

        ajouterMaison = new JButton("AJOUTER UNE MAISON");
        ajouterMaison.setBackground(new Color(200, 255, 200));
        ajouterMaison.setFont(new Font("Arial", Font.BOLD, 20));
        add(ajouterMaison, BorderLayout.SOUTH);

        add(header, BorderLayout.NORTH);

        header.add(Box.createRigidArea(new Dimension(5, 20)));

        // Corps principal avec les maisons
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1, 3, 5, 5));
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Exemples de maisons
        content.add(creerCarteMaison("CHINE", "Transverse/src/vues/img/chine.jpg"));
        content.add(creerCarteMaison("ITALIE", "Transverse/src/vues/img/italie.jpg"));
        content.add(creerCarteMaison("INTERNATIONALE", "Transverse/src/vues/img/Internationale.jpg"));

        

        add(content, BorderLayout.CENTER);

        // Bouton ajouter
        JButton ajouterMaison = new JButton("AJOUTER UNE MAISON");
        ajouterMaison.setBackground(new Color(200, 255, 200));
        ajouterMaison.setFont(new Font("Arial", Font.BOLD, 20));
        add(ajouterMaison, BorderLayout.SOUTH);
        setVisible(true);
    }
    private JPanel creerCarteMaison(String nom, String imagePath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        // Image
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        panel.add(imageLabel);
    
        // Espace
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
    
        // Nom (bouton)
        JButton nomBouton = new JButton(nom.toUpperCase());
        nomBouton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nomBouton.setBackground(new Color(180, 255, 200));
        nomBouton.setFont(new Font("Arial", Font.BOLD, 20));
        nomBouton.setFocusPainted(false);
        nomBouton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(100, 100, 100)),
            BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
        panel.add(nomBouton);
    
        // Espace
        panel.add(Box.createRigidArea(new Dimension(5, 8)));
    
        // Action sur clic du bouton : ouvrir les infos
        nomBouton.addActionListener(e -> {
            if (nom.equalsIgnoreCase("CHINE")) {
                new VueMaisonDetail("Maison de la Chine", imagePath,
                        "200 étudiants", "WiFi, Cantine, Salle de sport",
                        "Étudiants de 15 pays", "Actuellement : 150 résidents",
                        "30 rue Exemple", "XX XX XX XX XX");
            } else if (nom.equalsIgnoreCase("ITALIE")) {
                new VueMaisonDetail("Maison d'Italie", imagePath,
                        "180 étudiants", "WiFi, Salle de sport, Théâtre",
                        "Étudiants de 20 pays", "Actuellement : 130 résidents",
                        "20 rue Exemple", "XX XX XX XX XX");
            } else if (nom.equalsIgnoreCase("INTERNATIONALE")) {
                new VueMaisonDetail("Maison Internationale", imagePath,
                        "220 étudiants", "WiFi, Salle commune, Cinéma",
                        "Étudiants de 25 pays", "Actuellement : 170 résidents",
                        "60 rue Exemple", "XX XX XX XX XX");
            }
        });
    
        return panel;
    }
    

    public static void main(String[] args) {
        VueMaisons vue = new VueMaisons();
    }
}
