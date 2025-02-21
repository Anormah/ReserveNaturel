package com.reservenaturelle.model;

import com.reservenaturelle.interfaces.Mangeable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Random;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Animal {
    protected String nom;
    protected int age;
    protected double poids;
    protected double taille;
    protected String etatDeSante;
    protected String sexe;

    public Animal() {} // Constructeur vide nécessaire pour Jackson

    public Animal(String nom, int age, double poids, double taille, String etatDeSante, String sexe) {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
        this.taille = taille;
        this.etatDeSante = etatDeSante;
        this.sexe = sexe;
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

    public void seReproduire(Animal partenaire) {
        if (this.getClass() == partenaire.getClass() && !this.sexe.equals(partenaire.getSexe()) && this.age >= 2 && partenaire.age >= 2) {
            System.out.println(this.nom + " et " + partenaire.getNom() + " se reproduisent !");
            // Ajoute un nouveau bébé de la même espèce
            String bebeNom = "Bébé " + this.nom;
            String bebeSexe = new Random().nextBoolean() ? "Mâle" : "Femelle";
            Animal bebe = new Animal(bebeNom, 0, this.poids / 4, this.taille / 2, "Bon", bebeSexe);
            System.out.println("Un nouveau-né est né : " + bebe.getNom() + " (" + bebe.getSexe() + ")");
        }
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
    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }
}
