package com.reservenaturelle.main;

import com.reservenaturelle.habitat.*;
import com.reservenaturelle.model.*;
import com.reservenaturelle.interfaces.Soigneur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Animal> animaux = new ArrayList<>();
    private static List<Habitat> habitats = new ArrayList<>();
    private static List<Employe> employes = new ArrayList<>();
    private static List<Visiteur> visiteurs = new ArrayList<>();

    public static void main(String[] args) {
        initialiserReserve();
        simulation();
    }

    private static void initialiserReserve() {
        // Création d'animaux
        Animal lion = new Lion("Simba", 5, 190, 1.2, "Bon");
        Animal serpent = new Reptile("Kaa", 3, 15, 0.5, "Bon");
        Animal aigle = new Oiseau("Aiglon", 2, 6, 0.8, "Bon");
        Animal poisson = new Poisson("Nemo", 1, 0.5, 0.3, "Bon");

        animaux.add(lion);
        animaux.add(serpent);
        animaux.add(aigle);
        animaux.add(poisson);

        // Création d'habitats
        Habitat savane = new Savane("Savane Africaine", 5000, 30);
        Habitat voliere = new Voliere("Volière Tropicale", 200, 28);
        Habitat aquarium = new Aquarium("Aquarium Marin", 300, 22);

        habitats.add(savane);
        habitats.add(voliere);
        habitats.add(aquarium);

        // Ajout des animaux aux habitats
        savane.ajouterAnimal(lion);
        voliere.ajouterAnimal(aigle);
        aquarium.ajouterAnimal(poisson);
        // Vous pouvez ajouter d'autres associations selon la logique de votre réserve

        // Création d'employés
        Employe soigneur = new SoigneurEmploye("Alice", 2500);
        Employe veterinaire = new Veterinaire("Bob", 3000);

        employes.add(soigneur);
        employes.add(veterinaire);

        // Création de visiteurs
        Visiteur visiteur1 = new Visiteur("Charlie", 30, 15);
        Visiteur visiteur2 = new Visiteur("Diana", 25, 15);

        visiteurs.add(visiteur1);
        visiteurs.add(visiteur2);
    }

    private static void simulation() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("\n=== Simulation de la Réserve Naturelle ===");
            System.out.println("1. Afficher les animaux");
            System.out.println("2. Afficher les habitats");
            System.out.println("3. Effectuer les tâches des employés");
            System.out.println("4. Passer une journée");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    afficherAnimaux();
                    break;
                case "2":
                    afficherHabitats();
                    break;
                case "3":
                    effectuerTaches();
                    break;
                case "4":
                    passerJournee();
                    break;
                case "5":
                    System.out.println("Fin de la simulation.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (!input.equals("5"));
    }

    private static void afficherAnimaux() {
        System.out.println("\nListe des animaux :");
        for (Animal a : animaux) {
            System.out.println("- " + a.getNom() + " (Âge: " + a.getAge() + ")");
        }
    }

    private static void afficherHabitats() {
        System.out.println("\nListe des habitats :");
        for (Habitat h : habitats) {
            System.out.println("- " + h.getNom() + " (Animaux: " + h.getAnimaux().size() + ")");
        }
    }

    private static void effectuerTaches() {
        System.out.println("\nLes employés effectuent leurs tâches :");
        for (Employe e : employes) {
            e.effectuerTache();
            // Si l'employé implémente l'interface Soigneur, il peut nourrir et soigner un animal
            if (e instanceof Soigneur) {
                Soigneur s = (Soigneur) e;
                if (!animaux.isEmpty()) {
                    s.nourrir(animaux.get(0));
                    s.soigner(animaux.get(0));
                }
            }
        }
    }

    // Méthode qui simule le passage d'une journée
    private static void passerJournee() {
        System.out.println("\nUne nouvelle journée commence...");

        // Exemple : vieillir les animaux
        for (Animal a : animaux) {
            a.setAge(a.getAge() + 1);
            System.out.println(a.getNom() + " a maintenant " + a.getAge() + " ans.");
        }

        // Nettoyage des habitats
        for (Habitat h : habitats) {
            h.nettoyer();
        }

        // Vous pouvez ajouter ici d'autres événements (reproduction, incidents, etc.)
        System.out.println("La journée s'est écoulée.\n");
    }
}
