package com.reservenaturelle.habitat;

import com.reservenaturelle.model.Animal;
import com.reservenaturelle.model.Lion;
import com.reservenaturelle.model.Poisson;
import com.reservenaturelle.model.Oiseau;
import com.reservenaturelle.model.Reptile;
import java.util.ArrayList;
import java.util.List;

public abstract class Habitat {
    protected String nom;
    protected double taille;
    protected double temperature;
    protected List<Animal> animaux;

    public Habitat(String nom, double taille, double temperature) {
        this.nom = nom;
        this.taille = taille;
        this.temperature = temperature;
        this.animaux = new ArrayList<>();
    }

    public void ajouterAnimal(Animal a) {
        for (Animal resident : animaux) {
            if ((resident instanceof Lion && a instanceof Poisson) ||
                    (resident instanceof Lion && a instanceof Oiseau) ||
                    (resident instanceof Reptile && a instanceof Oiseau)) {
                System.out.println("Erreur : " + a.getNom() + " ne peut pas cohabiter avec " + resident.getNom());
                return;
            }
        }
        animaux.add(a);
        System.out.println(a.getNom() + " ajouté à " + nom);
    }

    public abstract void nettoyer();

    // Getters
    public String getNom() {
        return nom;
    }

    public double getTaille() {
        return taille;
    }

    public double getTemperature() {
        return temperature;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }
}
