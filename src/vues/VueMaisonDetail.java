package vues;

import javax.swing.*;
import java.awt.*;

public class VueMaisonDetail extends JFrame {

    public VueMaisonDetail(String nomMaison, String imagePath, String capacite, String services, String nationalites, String nbActuels, String adresse, String tel) {
        setTitle("Détail : " + nomMaison);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // En-tête
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(180, 255, 200));
        JLabel logo = new JLabel("CITE INTERNATIONALE UNIVERSITAIRE DE PARIS");
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        header.add(logo, BorderLayout.WEST);
        JButton homeBtn = new JButton("🏠");
        header.add(homeBtn, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // Corps principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Gauche : Image + Adresse
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(imgLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(new JLabel("Adresse : " + adresse));
        leftPanel.add(new JLabel("Tel : " + tel));
        mainPanel.add(leftPanel, BorderLayout.WEST);

        // Centre : Détails
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createTitledBorder("INFORMATION"));
        infoPanel.setBackground(new Color(230, 255, 230));

        infoPanel.add(new JLabel("Capacité d'accueil : " + capacite));
        infoPanel.add(new JLabel("Services : " + services));
        infoPanel.add(new JLabel("Nationalités représentées : " + nationalites));
        infoPanel.add(new JLabel("Nombre d'étudiants actuels : " + nbActuels));

        // Boutons
        JPanel btns = new JPanel(new FlowLayout());
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnSupprimer = new JButton("Supprimer");
        btnAjouter.setBackground(new Color(150, 255, 150));
        btnSupprimer.setBackground(new Color(255, 150, 150));
        btns.add(btnAjouter);
        btns.add(btnSupprimer);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(btns);

        mainPanel.add(infoPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
