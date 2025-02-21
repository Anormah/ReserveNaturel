package com.reservenaturelle.model;

import com.reservenaturelle.interfaces.Mangeable;

public class Oiseau extends Animal implements Mangeable {

    public Oiseau(String nom, int age, double poids, double taille, String etatDeSante, String sexe) {
        super(nom, age, poids, taille, etatDeSante, sexe);
    }

    public void voler() {
        System.out.println(nom + " vole.");
    }

    @Override
    public void etreMange() {
        System.out.println(nom + " a été mangé !");
    }
}
