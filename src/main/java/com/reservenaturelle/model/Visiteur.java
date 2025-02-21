package com.reservenaturelle.model;

public class Visiteur {
    private String nom;
    private int age;
    private double billet;

    public Visiteur(String nom, int age, double billet) {
        this.nom = nom;
        this.age = age;
        this.billet = billet;
    }

    public void observerAnimal(Animal a) {
        System.out.println(nom + " observe " + a.getNom());
    }

    public void acheterBillet() {
        System.out.println(nom + " achète un billet.");
    }

    // Getters
    public String getNom() {
        return nom;
    }
    public int getAge() {
        return age;
    }
    public double getBillet() {
        return billet;
    }
}
