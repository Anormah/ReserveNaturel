package com.reservenaturelle.habitat;

public class Aquarium extends Habitat {

    public Aquarium(String nom, double taille, double temperature) {
        super(nom, taille, temperature);
    }

    @Override
    public void nettoyer() {
        System.out.println("Nettoyage de l'aquarium " + nom);
    }
}
