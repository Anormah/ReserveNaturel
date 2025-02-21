package com.reservenaturelle.main;

import com.reservenaturelle.habitat.*;
import com.reservenaturelle.model.*;
import com.reservenaturelle.interfaces.Soigneur;
import com.reservenaturelle.utils.Sauvegarde;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainFX extends Application {

    private List<Animal> animaux = new ArrayList<>();
    private List<Habitat> habitats = new ArrayList<>();
    private List<Employe> employes = new ArrayList<>();
    private List<Visiteur> visiteurs = new ArrayList<>();

    private ListView<String> animalListView;
    private ListView<String> habitatListView;
    private ListView<String> visiteurListView;
    private TextArea logArea;
    private Label revenuLabel;

    private double revenu = 0.0;
    private final double PRIX_BILLET = 15.0;

    public static void main(String[] args) {
        launch(args);
    }

    private void updateAnimalList() {
        animalListView.getItems().clear();
        for (Animal a : animaux) {
            String type = "";
            if (a instanceof Lion) type = "Lion";
            else if (a instanceof Reptile) type = "Reptile";
            else if (a instanceof Oiseau) type = "Oiseau";
            else if (a instanceof Poisson) type = "Poisson";

            // Déterminer l'affichage du sexe (♂ ou ♀)
            String sexeSymbol = a.getSexe().equals("Mâle") ? "♂" : "♀";

            animalListView.getItems().add(a.getNom() + " " + sexeSymbol + " (" + type + ") " + a.getAge() + " ans");
        }
    }


    private void updateHabitatList() {
        habitatListView.getItems().clear();
        for (Habitat h : habitats) {
            habitatListView.getItems().add(h.getNom() + " (Animaux: " + h.getAnimaux().size() + ")");
        }
    }

    private void updateVisiteurList() {
        visiteurListView.getItems().clear();
        for (Visiteur v : visiteurs) {
            visiteurListView.getItems().add(v.getNom() + " (" + v.getAge() + " ans)");
        }
    }

    private void passerJournee() {
        logArea.appendText("Une nouvelle journée commence...\n");

        // Vieillissement des animaux
        for (Animal a : animaux) {
            a.setAge(a.getAge() + 1);
            logArea.appendText(a.getNom() + " a maintenant " + a.getAge() + " ans.\n");
        }

        // Reproduction des animaux de la même espèce et sexe opposé
        for (int i = 0; i < animaux.size(); i++) {
            for (int j = i + 1; j < animaux.size(); j++) {
                Animal a1 = animaux.get(i);
                Animal a2 = animaux.get(j);

                // Vérifie s'ils sont de la même espèce et de sexe opposé
                if (a1.getClass().equals(a2.getClass()) && !a1.getSexe().equals(a2.getSexe())) {
                    a1.seReproduire(a2);
                }
            }
        }

        // Nettoyage des habitats
        for (Habitat h : habitats) {
            h.nettoyer();
            logArea.appendText("Nettoyage de " + h.getNom() + "\n");
        }

        logArea.appendText("La journée s'est écoulée.\n\n");
    }



    private void effectuerTaches() {
        logArea.appendText("Les employés effectuent leurs tâches :\n");

        for (Employe e : employes) {
            e.effectuerTache();
            logArea.appendText(e.getNom() + " effectue sa tâche.\n");

            // Si l'employé est un soigneur, il nourrit et soigne un animal
            if (e instanceof Soigneur) {
                Soigneur s = (Soigneur) e;
                if (!animaux.isEmpty()) {
                    s.nourrir(animaux.get(0));
                    logArea.appendText(e.getNom() + " nourrit " + animaux.get(0).getNom() + ".\n");
                    s.soigner(animaux.get(0));
                    logArea.appendText(e.getNom() + " soigne " + animaux.get(0).getNom() + ".\n");
                }
            }
        }

        logArea.appendText("\n");
    }




    @Override
    public void start(Stage primaryStage) {
        initialiserReserve();
        primaryStage.setTitle("Réserve Naturelle - Simulation");

        animalListView = new ListView<>();
        updateAnimalList();
        VBox leftBox = new VBox(new Label("Animaux"), animalListView);
        leftBox.setSpacing(10);
        leftBox.setPrefWidth(250);

        habitatListView = new ListView<>();
        updateHabitatList();
        VBox rightBox = new VBox(new Label("Habitats"), habitatListView);
        rightBox.setSpacing(10);
        rightBox.setPrefWidth(250);

        visiteurListView = new ListView<>();
        updateVisiteurList();
        VBox visitorBox = new VBox(new Label("Visiteurs"), visiteurListView);
        visitorBox.setSpacing(10);
        visitorBox.setPrefWidth(250);

        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefHeight(300);

        revenuLabel = new Label("Revenu: " + revenu + " €");

        Button btnPasserJournee = new Button("Passer une journée");
        btnPasserJournee.setOnAction(e -> {
            passerJournee();
            updateAnimalList();
            updateHabitatList();
        });

        Button btnAfficherTaches = new Button("Tâches des employés");
        btnAfficherTaches.setOnAction(e -> effectuerTaches());

        Button btnAjouterVisiteur = new Button("Ajouter Visiteur");
        btnAjouterVisiteur.setOnAction(e -> {
            ajouterVisiteur();
            updateVisiteurList();
            revenuLabel.setText("Revenu: " + revenu + " €");
        });

        Button btnSauvegarder = new Button("Sauvegarder");
        btnSauvegarder.setOnAction(e -> {
            Sauvegarde.sauvegarderZoo(animaux);
            logArea.appendText("Données sauvegardées !\n");
        });

        Button btnCharger = new Button("Charger");
        btnCharger.setOnAction(e -> {
            List<Animal> loadedAnimals = Sauvegarde.chargerZoo();
            if (loadedAnimals != null) {
                animaux.clear();
                animaux.addAll(loadedAnimals);
                updateAnimalList();
                logArea.appendText("Données chargées !\n");
            }
        });

        HBox bottomBox = new HBox(btnPasserJournee, btnAfficherTaches, btnAjouterVisiteur, btnSauvegarder, btnCharger);
        bottomBox.setSpacing(10);

        BorderPane root = new BorderPane();
        root.setLeft(leftBox);
        root.setRight(rightBox);
        root.setCenter(logArea);
        root.setBottom(bottomBox);

        VBox topBox = new VBox(revenuLabel, visitorBox);
        topBox.setSpacing(10);
        root.setTop(topBox);

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initialiserReserve() {
        Habitat savane = new Savane("Savane Africaine", 5000, 30);
        Habitat voliere = new Voliere("Volière Tropicale", 200, 28);
        Habitat aquarium = new Aquarium("Aquarium Marin", 300, 22);
        habitats.add(savane);
        habitats.add(voliere);
        habitats.add(aquarium);

        genererAnimaux(30);
        repartirAnimauxDansHabitats();

        employes.add(new SoigneurEmploye("Singed", 2500));
        employes.add(new Veterinaire("Dr Mundo", 3000));
    }

    private void genererAnimaux(int nombre) {
        String[] nomsLol = {
                "Aatrox", "Ahri", "Akali", "Ashe", "Braum", "Caitlyn", "Darius", "Draven", "Ekko", "Ezreal",
                "Fiora", "Galio", "Garen", "Gragas", "Janna", "Jhin", "Jinx", "Kayn", "Kennen", "Leona",
                "Lux", "Malphite", "Morgana", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Pantheon", "Pyke", "Rengar",
                "Sejuani", "Senna", "Sett", "Shyvana", "Sion", "Soraka", "Swain", "Sylas", "Tahm Kench", "Talon",
                "Taliyah", "Twitch", "Varus", "Veigar", "Volibear", "Warwick", "Wukong", "Xayah", "Yasuo", "Zed"
        };

        String[] etatsSante = {"Bon", "Moyen", "Mauvais"};
        String[] sexes = {"Mâle", "Femelle"}; // Sexe aléatoire
        Random random = new Random();

        for (int i = 0; i < nombre; i++) {
            String nom = nomsLol[random.nextInt(nomsLol.length)];
            int age = random.nextInt(15) + 1;
            String etat = etatsSante[random.nextInt(etatsSante.length)];
            String sexe = sexes[random.nextInt(sexes.length)]; // Attribuer un sexe aléatoire

            Animal animal;
            switch (random.nextInt(4)) {
                case 0 -> animal = new Lion(nom, age, 180 + random.nextInt(50), 1.1 + random.nextDouble(), etat, sexe);
                case 1 -> animal = new Reptile(nom, age, 10 + random.nextInt(40), 0.5 + random.nextDouble(), etat, sexe);
                case 2 -> animal = new Oiseau(nom, age, 2 + random.nextInt(5), 0.3 + random.nextDouble(), etat, sexe);
                case 3 -> animal = new Poisson(nom, age, 0.2 + random.nextDouble(), 0.1 + random.nextDouble(), etat, sexe);
                default -> throw new IllegalStateException("Type d'animal non reconnu !");
            }
            animaux.add(animal);
        }
    }



    private void repartirAnimauxDansHabitats() {
        Random random = new Random();
        for (Animal a : animaux) {
            if (a instanceof Lion) habitats.get(0).ajouterAnimal(a);
            else if (a instanceof Oiseau) habitats.get(1).ajouterAnimal(a);
            else if (a instanceof Poisson) habitats.get(2).ajouterAnimal(a);
            else habitats.get(random.nextInt(2)).ajouterAnimal(a);
        }
    }

    private void ajouterVisiteur() {
        String[] nomsVisiteurs = {"Evelyn", "Noah", "Emma", "Liam", "Olivia", "Mason", "Ava", "Jacob", "Sophia", "William"};
        Random random = new Random();
        String nom = nomsVisiteurs[random.nextInt(nomsVisiteurs.length)];
        int age = random.nextInt(50) + 18;
        visiteurs.add(new Visiteur(nom, age, PRIX_BILLET));
        revenu += PRIX_BILLET;
        logArea.appendText(nom + " (âge: " + age + ") a visité la réserve. Revenu + " + PRIX_BILLET + "€\n");
    }
}
