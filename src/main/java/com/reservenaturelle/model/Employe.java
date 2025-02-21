package com.reservenaturelle.model;

public class Employe {
    protected String nom;
    protected String poste;
    protected double salaire;

    public Employe(String nom, String poste, double salaire) {
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

    public void effectuerTache() {
        System.out.println(nom + " effectue sa tâche en tant que " + poste);
    }

    // Getters
    public String getNom() {
        return nom;
    }
    public String getPoste() {
        return poste;
    }
    public double getSalaire() {
        return salaire;
    }
}
