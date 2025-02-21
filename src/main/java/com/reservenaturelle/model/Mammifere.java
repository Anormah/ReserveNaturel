package com.reservenaturelle.model;

public class Mammifere extends Animal {

    public Mammifere(String nom, int age, double poids, double taille, String etatDeSante) {
        super(nom, age, poids, taille, etatDeSante);
    }

    public void allaiter() {
        System.out.println(nom + " allaite ses petits.");
    }
}
