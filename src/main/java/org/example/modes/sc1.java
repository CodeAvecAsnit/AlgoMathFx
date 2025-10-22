package org.example.modes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author : Asnit Bakhati
 */
public class sc1 {
    @FXML
    public TextField t0;
    @FXML
    public TextField t1;
    @FXML
    public TextField t2;


    @FXML
    public AnchorPane pane;

    @FXML
    public Label x1;

    @FXML
    public Label x2;

    private Stage stage;

    @FXML
    public void find1(ActionEvent e) {
        try {
            float a = Float.parseFloat(t2.getText());
            float b = Float.parseFloat(t1.getText());
            System.out.println(b);
            float c = Float.parseFloat(t0.getText());
            float k = (float) Math.sqrt(Math.pow(b, 2) - 4 * a * c);
            x1.setText("x1 : " + String.valueOf((b + k) / 2 * a));
            x2.setText("x2 : " + String.valueOf((b - k) / 2 * a));
        } catch (Exception exe) {
            clear_out(new ActionEvent());
        }
    }

    @FXML
    public void clear_out(ActionEvent e) {
        t0.setText("");
        t1.setText("");
        t2.setText("");
        x1.setText("");
        x2.setText("");
    }

    @FXML
    public void swig(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Exit_out(ActionEvent e) {
        stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}