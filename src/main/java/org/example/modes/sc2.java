package org.example.modes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Calculate.Newton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class sc2{

    @FXML
    public TextField t0, t1, t2, t3;

    @FXML
    public Label x1;

    @FXML
    public Label x2;

    @FXML
    public Label x3;

     private Newton n = new Newton();
    @FXML
    public AnchorPane pane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void find1(ActionEvent e) {
            int degree = 3;

            float[] var = new float[degree + 1];

            var[0] = Float.parseFloat(t0.getText());
             var[1] = Float.parseFloat(t1.getText());
              var[2] = Float.parseFloat(t2.getText());
              var[3] = Float.parseFloat(t3.getText());
            float xne1 = 0;
                xne1 = roundup(n.newtonRaphson(var, degree + 1));
                var = n.horn(var, xne1, degree + 1);
            float a = var[0];
            float b = var[1];
            float c = var[2];
            float k = (float) Math.sqrt(Math.pow(b, 2) - 4 * a * c);
            x1.setText("x1 : " + String.valueOf((1/((-b + k) / (2 * a)))));
            x2.setText("x2 : " + String.valueOf(1/((-b - k) / (2 * a))));
            x3.setText("x3 : " + String.valueOf(1/xne1));
    }
    @FXML
    public void clear_out(ActionEvent e) {
        t0.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        x1.setText("");
        x2.setText("");
        x3.setText("");
    }

    @FXML
    public void swig(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public float roundup(float x) {
        if (Math.abs(Math.ceil(x) - x) < 0.02) {
            return (float) Math.ceil(x);
        } else if (Math.abs(Math.floor(x) - x) < 0.02) {
            return (float) Math.floor(x);
        } else {
            return x;
        }
    }

    public void Exit_out(ActionEvent e){
        stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }


}
