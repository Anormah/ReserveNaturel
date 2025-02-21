package com.reservenaturelle.model;

import com.reservenaturelle.interfaces.Soigneur;

public class SoigneurEmploye extends Employe implements Soigneur {

    public SoigneurEmploye(String nom, double salaire) {
        super(nom, "Soigneur", salaire);
    }

    @Override
    public void nourrir(Animal a) {
        System.out.println(nom + " nourrit " + a.getNom());
        a.manger();
    }

    @Override
    public void soigner(Animal a) {
        System.out.println(nom + " soigne " + a.getNom());
        // Vous pouvez ajouter ici la logique pour améliorer l'état de santé de l'animal
    }

    @Override
    public void effectuerTache() {
        System.out.println(nom + " effectue des tâches de soin et de nourrissage.");
    }
}
