package com.reservenaturelle.model;

public class Poisson extends Animal {

    public Poisson(String nom, int age, double poids, double taille, String etatDeSante) {
        super(nom, age, poids, taille, etatDeSante);
    }

    public void nager() {
        System.out.println(nom + " nage.");
    }
}
