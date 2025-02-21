package com.reservenaturelle.model;

import com.reservenaturelle.interfaces.Mangeable;

public class Poisson extends Animal implements Mangeable {

    public Poisson(String nom, int age, double poids, double taille, String etatDeSante, String sexe) {
        super(nom, age, poids, taille, etatDeSante, sexe);
    }

    public void nager() {
        System.out.println(nom + " nage.");
    }

    @Override
    public void etreMange() {
        System.out.println(nom + " a été mangé !");
    }
}
