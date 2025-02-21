package com.reservenaturelle.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservenaturelle.model.Animal;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Sauvegarde {
    private static final String FICHIER_JSON = "zoo.json";

    public static void sauvegarderZoo(List<Animal> animaux) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FICHIER_JSON), animaux);
            System.out.println("Données sauvegardées !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Animal> chargerZoo() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return List.of(mapper.readValue(new File(FICHIER_JSON), Animal[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
