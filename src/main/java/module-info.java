module org.example.modes {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.modes to javafx.fxml;
    exports org.example.modes;
}