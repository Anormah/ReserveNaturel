package com.reservenaturelle.model;

public class Lion extends Mammifere {
    public Lion(String nom, int age, double poids, double taille, String etatDeSante, String sexe) {
        super(nom, age, poids, taille, etatDeSante, sexe);
    }

    public void rugir() {
        System.out.println(nom + " rugit !");
    }

    @Override
    public void emettreSon() {
        rugir();
    }
}
