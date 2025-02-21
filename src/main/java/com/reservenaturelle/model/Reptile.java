package com.reservenaturelle.model;

public class Reptile extends Animal {

    public Reptile(String nom, int age, double poids, double taille, String etatDeSante, String sexe) {
        super(nom, age, poids, taille, etatDeSante, sexe);
    }

    public void pondreOeuf() {
        System.out.println(nom + " pond des œufs.");
    }
}
