module org.example.modes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.modes to javafx.fxml;
    exports org.example.modes;
}