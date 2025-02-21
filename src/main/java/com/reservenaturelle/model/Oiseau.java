package com.reservenaturelle.model;

public class Oiseau extends Animal {

    public Oiseau(String nom, int age, double poids, double taille, String etatDeSante) {
        super(nom, age, poids, taille, etatDeSante);
    }

    public void voler() {
        System.out.println(nom + " vole.");
    }
}
