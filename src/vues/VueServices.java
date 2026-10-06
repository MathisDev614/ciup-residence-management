package vues;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import modeles.Service;

public class VueServices extends JFrame {

    public VueServices(Service serviceModel) {
        setTitle("Services - Maison Internationale");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Barre d'en-tête
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(200, 220, 255));

        JLabel titre = new JLabel("SERVICES DISPONIBLES");
        titre.setFont(new Font("Arial", Font.BOLD, 18));
        titre.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        header.add(titre, BorderLayout.WEST);

        // Barre de recherche avec placeholder
        JTextField searchBar = new JTextField("Rechercher un service...");
        searchBar.setForeground(Color.GRAY);
        searchBar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchBar.getText().equals("Rechercher un service...")) {
                    searchBar.setText("");
                    searchBar.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (searchBar.getText().isEmpty()) {
                    searchBar.setText("Rechercher un service...");
                    searchBar.setForeground(Color.GRAY);
                }
            }
        });
        header.add(searchBar, BorderLayout.CENTER);

        JButton retourButton = new JButton("🏠");
        header.add(retourButton, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // Panel principal
        JPanel content = new JPanel(new GridLayout(0, 2, 20, 20));
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JScrollPane scrollPane = new JScrollPane(content);
        add(scrollPane, BorderLayout.CENTER);

        // Afficher tous les services
        ArrayList<String> noms = serviceModel.getServiceMaisonInternational();
        ArrayList<String> horaires = serviceModel.getHoraireListe();
        ArrayList<String> descriptions = serviceModel.getDescription();
        ArrayList<String> images = serviceModel.getImagePath();

        for (int i = 0; i < noms.size(); i++) {
            content.add(creerCarteService(noms.get(i), horaires.get(i), descriptions.get(i), images.get(i)));
        }

        // Bas de fenêtre : bouton ajouter
        JButton ajouterService = new JButton("AJOUTER UN SERVICE");
        ajouterService.setBackground(new Color(220, 240, 255));
        ajouterService.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Fonction à implémenter");
        });
        add(ajouterService, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel creerCarteService(String nom, String horaire, String description, String imagePath) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Titre du service
        JLabel titre = new JLabel(nom, SwingConstants.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titre, BorderLayout.NORTH);

        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(img));
            panel.add(imageLabel, BorderLayout.CENTER);
        }

        // Description + Horaire
        JTextArea infos = new JTextArea(horaire + "\n" + description);
        infos.setLineWrap(true);
        infos.setWrapStyleWord(true);
        infos.setEditable(false);
        infos.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(infos, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        // Simulation du modèle avec des données fictives
        Service serviceModel = new Service();
        serviceModel.ajouterService("8h-18h", "Bibliothèque", "Accès libre aux étudiants avec emprunt de livres.", "Transverse/src/vues/img/chine.jpg");
        serviceModel.ajouterService("12h-14h", "Cafétéria", "Repas chauds et snacks végétariens.", "");
        serviceModel.ajouterService("9h-20h", "Piscine", "Piscine couverte avec réservations.", "");
        serviceModel.ajouterService("18h-22h", "Théâtre", "Spectacles et représentations étudiantes.", "");

        new VueServices(serviceModel);
    }
}