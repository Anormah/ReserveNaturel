module com.reservenaturelle.mareservenaturelle {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    // Ouvre le package `model` à Jackson pour éviter les problèmes d'accès
    opens com.reservenaturelle.model to com.fasterxml.jackson.databind;

    // Si d'autres classes doivent être sérialisées, ouvre aussi leurs packages
    opens com.reservenaturelle.habitat to com.fasterxml.jackson.databind;
    opens com.reservenaturelle.interfaces to com.fasterxml.jackson.databind;

    // Exporte les packages nécessaires
    exports com.reservenaturelle.main;
    exports com.reservenaturelle.model;
    exports com.reservenaturelle.habitat;
    exports com.reservenaturelle.interfaces;
}
