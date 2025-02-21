module com.reservenaturelle.mareservenaturelle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.reservenaturelle.main to javafx.fxml;
    exports com.reservenaturelle.main;
}