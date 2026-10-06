# 🏢 Cité Universitaire Management System — Java & MVC

Application de bureau en **Java (Swing)** conçue pour administrer et gérer les résidences étudiantes, les hébergements internationaux, les services partagés et la restauration universitaire (inspirée du fonctionnement de la Cité Internationale Universitaire de Paris).

Le projet s'appuie sur le patron d'architecture **MVC (Modèle - Vue - Contrôleur)** afin de garantir un code découplé, maintenable et testable.

---

## 🌟 Fonctionnalités Principales

- **Gestion des résidences (Maisons) :**
  - Consultation des différentes résidences et de leurs caractéristiques (capacité d'accueil, localisation, directeur).
  - Gestion de la disponibilité des chambres avec contrôle des capacités limites (`NB_MAX_ETUDIANTS`).
- **Gestion des résidents (Étudiants) :**
  - Fiche détaillée de l'étudiant (identifiant unique auto-incrémenté, nom, prénom, nationalité, statut d'ancien résident).
  - Attribution et libération de chambres par maison avec mise à jour bidirectionnelle des liaisons.
- **Maison Internationale & Services :**
  - Gestion des infrastructures communes : bibliothèque, cafétéria, piscine, théâtre (horaires, descriptions et visuels).
  - Module de restauration universitaire (`RestoU`) avec planning de menus sur 7 jours.

---

## 👥 Contexte & Mes Contributions

Projet réalisé en équipe dans un cadre universitaire, mettant en avant le développement collaboratif et la séparation des responsabilités via le pattern MVC.

### Mes réalisations sur le projet :
- **Module Étudiant (Full-Stack MVC) :**
  - Conception et développement complet de la **`VueEtudiant`** (interface graphique Swing pour la fiche détaillée et les formulaires).
  - Implémentation du **contrôleur associé** pour la capture et le traitement des interactions utilisateurs.
- **Liaison inter-modules (Maisons ↔ Étudiants) :**
  - Mise en place de l'interconnexion entre la vue d'une Maison et les fiches Étudiants.
  - Gestion de la navigation contextuelle permettant de consulter dynamiquement la liste et les détails des étudiants rattachés à une résidence donnée.

---

## 📐 Architecture Logicielle

Le projet est rigoureusement découpé selon le design pattern **MVC** :

- **Modèles (`modeles`) :**
  - `Maison` & `MaisonInternationale` : Héritage et spécialisation de la logique d'hébergement.
  - `Etudiant` : Gestion des résidents et affectations.
  - `RestoU` & `Service` : Entités représentant les prestations de la résidence.
  - `FactoryCIUP` : Patron de création (**Factory Pattern**) permettant d'initialiser et injecter un jeu de données cohérent.
- **Vues (`vues`) :**
  - Interfaces graphiques interactives développées en **Java Swing** (`VueMaisons`, `VueMaisonDetail`, `VueEtudiant`, `VueServices`).
  - Composants personnalisés, gestionnaires de disposition modulaires (`BorderLayout`, `GridLayout`, `BoxLayout`) et cartes visuelles.
- **Contrôleurs (`controleurs`) :**
  - Routage des actions utilisateurs et découplage entre les données métier et les formulaires d'affichage.
- **Tests Unitaires (`tests`) :**
  - Suite de tests unitaires couvrant les règles métier : ajouts conditionnels avec/sans chambre restante, intégrité des menus et instanciation du modèle.

---

## 🛠️ Prérequis

- **Java JDK 17** ou version ultérieure
- Un IDE Java (IntelliJ IDEA, Eclipse, VS Code) ou la ligne de commande (`javac`)

---

## 🚀 Compilation et Exécution

### En ligne de commande

```bash
# 1. Compilation des sources
javac -d bin -sourcepath src src/vues/VueMaisons.java

# 2. Lancement de l'application
java -cp bin vues.VueMaisons

```

### Exécution de la suite de tests

```bash
# Compilation des modèles et des tests
javac -d bin -sourcepath src:tests tests/CiteUniversitaireTest/MaisonTest.java

# Exécution avec activation des assertions (-ea)
java -ea -cp bin CiteUniversitaireTest.MaisonTest

```

---

## 📂 Structure du Répertoire

```text
├── src/
│   ├── controleurs/
│   │   └── ControleurMaison.java        # Contrôleur applicatif
│   ├── modeles/
│   │   ├── CIUP.java                    # Gestionnaire racine des résidences
│   │   ├── Etudiant.java                # Entité résident
│   │   ├── FactoryCIUP.java             # Fabrique d'initialisation des données
│   │   ├── Maison.java                  # Modèle de base d'une résidence
│   │   ├── MaisonInternationale.java    # Modèle spécialisé (services + Resto U)
│   │   ├── RestoU.java                  # Menus de la semaine
│   │   └── Service.java                 # Services et horaires
│   └── vues/
│       ├── img/                         # Assets graphiques des résidences
│       ├── VueEtudiant.java             # Fiche détaillée de l'étudiant
│       ├── VueMaisonDetail.java         # Détails d'une maison sélectionnée
│       ├── VueMaisons.java              # Tableau de bord principal des résidences
│       └── VueServices.java             # Affichage des services disponibles
├── tests/
│   └── CiteUniversitaireTest/           # Suite de tests unitaires
├── .gitignore
├── LICENSE
└── README.md

```

---

## 📄 Licence

Ce projet est sous licence MIT. Consultez le fichier [LICENSE](https://www.google.com/search?q=LICENSE) pour plus d'informations.
