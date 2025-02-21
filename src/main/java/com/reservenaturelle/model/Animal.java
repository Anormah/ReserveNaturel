package com.reservenaturelle.model;

public class Animal {
    protected String nom;
    protected int age;
    protected double poids;
    protected double taille;
    protected String etatDeSante;

    public Animal(String nom, int age, double poids, double taille, String etatDeSante) {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
        this.taille = taille;
        this.etatDeSante = etatDeSante;
    }

    public void manger() {
        System.out.println(nom + " mange.");
    }

    public void dormir() {
        System.out.println(nom + " dort.");
    }

    public void seDeplacer() {
        System.out.println(nom + " se déplace.");
    }

    public void emettreSon() {
        System.out.println(nom + " émet un son.");
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getPoids() {
        return poids;
    }
    public void setPoids(double poids) {
        this.poids = poids;
    }
    public double getTaille() {
        return taille;
    }
    public void setTaille(double taille) {
        this.taille = taille;
    }
    public String getEtatDeSante() {
        return etatDeSante;
    }
    public void setEtatDeSante(String etatDeSante) {
        this.etatDeSante = etatDeSante;
    }
}
