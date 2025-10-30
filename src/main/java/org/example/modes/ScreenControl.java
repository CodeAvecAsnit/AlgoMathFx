package org.example.modes;

import Calculate.NewtonsMethod;
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

public class ScreenControl {

    @FXML
    public TextField t0;

    @FXML
    public TextField t1;

    @FXML
    public TextField t2;

    @FXML
    public TextField t3;

    @FXML
    public TextField t4;


    @FXML
    public AnchorPane pane;


    @FXML
    public Label x1;

    @FXML
    public Label x2;

    @FXML
    public Label x3;

    @FXML
    public Label x4;


    private Stage stage;

    private final NewtonsMethod n = new NewtonsMethod();

    public void find3(ActionEvent e) {
        int degree = 4;
        float[] var = new float[degree + 1];

        try {
            var[0] = Float.parseFloat(t0.getText());
            var[1] = Float.parseFloat(t1.getText());
            var[2] = Float.parseFloat(t2.getText());
            var[3] = Float.parseFloat(t3.getText());
            var[4] = Float.parseFloat(t4.getText());
        } catch (NumberFormatException ex) {
            x4.setText("Invalid input");
            return;
        }

        float xne1 = roundup(n.newtonRaphson(var, degree + 1));
        if (Float.isNaN(xne1)) {
            x4.setText("newtonRaphson returned NaN");
            return;
        }

        var = n.horn(var, xne1, degree + 1);
        for (float value : var) {
            if (Float.isNaN(value)) {
                x4.setText("horn returned NaN coefficient");
                return;
            }
        }

        degree--;
        x4.setText("x4 : " + String.valueOf(xne1));
        xne1 = roundup(n.newtonRaphson(var, degree + 1));
        if (Float.isNaN(xne1)) {
            x4.setText("newtonRaphson returned NaN");
            return;
        }

        var = n.horn(var, xne1, degree + 1);
        for (float v : var) {
            if (Float.isNaN(v)) {
                x4.setText("horn returned NaN coefficient");
                return;
            }
        }

        float a = var[0];
        float b = var[1];
        float c = var[2];
        float discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            x1.setText("Discriminant is negative, cannot compute roots");
            x2.setText("Discriminant is negative, cannot compute roots");
            return;
        }
        float k = (float) Math.sqrt(discriminant);
        x1.setText("x1 : " + String.valueOf((-b + k) / (2 * a)));
        x2.setText("x2 : " + String.valueOf((-b - k) / (2 * a)));
        x3.setText("x3 : " + String.valueOf(xne1));
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

    @FXML
    public void clear_out(ActionEvent e){
        t0.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
    }

    @FXML
    public void swig(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        stage=(Stage) ((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Exit_out(ActionEvent e){
        stage=(Stage)pane.getScene().getWindow();
        stage.close();
    }
}
