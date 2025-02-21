package com.reservenaturelle.habitat;

public class Voliere extends Habitat {

    public Voliere(String nom, double taille, double temperature) {
        super(nom, taille, temperature);
    }

    @Override
    public void nettoyer() {
        System.out.println("Nettoyage de la volière " + nom);
    }
}
