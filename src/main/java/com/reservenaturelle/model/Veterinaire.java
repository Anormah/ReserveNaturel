package com.reservenaturelle.model;

import com.reservenaturelle.interfaces.Soigneur;

public class Veterinaire extends Employe implements Soigneur {

    public Veterinaire(String nom, double salaire) {
        super(nom, "Vétérinaire", salaire);
    }

    @Override
    public void nourrir(Animal a) {
        // Le vétérinaire ne nourrit pas directement les animaux
        System.out.println(nom + " ne nourrit pas directement " + a.getNom());
    }

    @Override
    public void soigner(Animal a) {
        System.out.println(nom + " soigne médicalement " + a.getNom());
        // Ajoutez ici la logique de soin médical
    }

    @Override
    public void effectuerTache() {
        System.out.println(nom + " effectue des soins médicaux.");
    }
}
