package com.reservenaturelle.habitat;

public class Savane extends Habitat {

    public Savane(String nom, double taille, double temperature) {
        super(nom, taille, temperature);
    }

    @Override
    public void nettoyer() {
        System.out.println("Nettoyage de la savane " + nom);
    }
}
