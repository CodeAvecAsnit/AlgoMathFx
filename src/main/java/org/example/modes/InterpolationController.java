package org.example.modes;

import Calculate.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Calculate.InterNode;
import java.io.IOException;
import java.util.Objects;

/**
 * @author : Asnit Bakhati
 */
public class InterpolationController {

   LinkedList ofx=new LinkedList();
    @FXML
    public TextField x;
    @FXML
    public TextField fx;
    @FXML
    public AnchorPane pane;
    @FXML
    Label answer;

    @FXML
    public TextField interpolate;


    public void close_out(ActionEvent e){
        Stage st = (Stage) pane.getScene().getWindow();
        st.close();
    }

    public void switch_modes(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        Stage stage = (Stage) ((javafx.scene.Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void generate(ActionEvent e) {
        InterNode newnode = null;
        try {
            float xVal = Float.parseFloat(x.getText());
            float fxVal = Float.parseFloat(fx.getText());
            newnode = new InterNode(xVal, fxVal);
        } catch (Exception ex) {
            showAlert("Please enter valid inputs");
            return;
        }
        ofx.add(newnode);

        float in;
        try {
            in = Float.parseFloat(interpolate.getText());
        } catch (NumberFormatException ex) {
            showAlert("Please enter a valid interpolation value");
            x.setText("");
            fx.setText("");
            return;
        }

        float interpolated = 0;

        for (InterNode temp = ofx.head; temp != null; temp = temp.next) {
            float mul = temp.fx;
            for (InterNode semp = ofx.head; semp != null; semp = semp.next) {
                if (semp != temp) {
                    mul *= (in - semp.x) / (temp.x - semp.x);
                }
            }
            interpolated += mul;
        }

        answer.setText("fx :" + String.format("%.2f", interpolated));
        x.setText("");
        fx.setText("");
        interpolate.setText("");
    }
    public void clear(ActionEvent e){
        answer.setText("");
        x.setText("");
        fx.setText("");
        interpolate.setText("");
        ofx.head=null;
    }

    public void add(ActionEvent e) {
        InterNode newnode = null;
        try {
            newnode = new InterNode(Float.parseFloat(x.getText()), Float.parseFloat(fx.getText()));
        } catch (Exception ex) {
            showAlert("Please enter valid inputs");
        }
        ofx.add(newnode);
        x.setText("");
        fx.setText("");
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
