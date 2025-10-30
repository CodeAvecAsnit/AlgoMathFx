package org.example.modes;

import Calculate.Calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author : Asnit Bakhati
 */
public class IntegrationController {

    @FXML
    public Label answer;

    @FXML
    AnchorPane pane;

    @FXML
    public TextField upper;

    @FXML
    public TextField lower;

    @FXML
    public TextField Function;

    @FXML
    public Button exit;

    public void find(ActionEvent e) {
        try {
            float high = Float.parseFloat(upper.getText());
            float low = Float.parseFloat(lower.getText());
            String func = Function.getText();

            float I = integrationPerformer(high, low, func);
            System.out.println(I);

            answer.setText(String.valueOf(I));

            upper.clear();
            lower.clear();
            Function.clear();
        } catch (NumberFormatException ex) {
            answer.setText("Invalid input. Please enter numeric values.");
        }
    }

    public float integrationPerformer(float high, float low, String func) {
        try {
            float integral = floatConverter(func, low) + floatConverter(func, high);
            float diff = (high - low) / 128;

            for (int i = 1; i < 128; ++i) {
                if (i % 3 == 0) {
                    integral += 2 * floatConverter(func, (low + diff * i));
                } else {
                    integral += 3 * floatConverter(func, (low + diff * i));
                }
            }

            integral *= (3 * diff) / 8;
            return integral;

        } catch (NumberFormatException | NullPointerException ex) {
            System.out.println("Error evaluating function: " + ex.getMessage());
            return Float.NaN;
        }
    }

    public float floatConverter(String fc, float x) {
        Calculator calculator = new Calculator();
        try {
            fc = fc.replace("x", String.valueOf(x));
            fc = fc.replace("X", String.valueOf(x));

            String mm = String.valueOf(calculator.calculate(fc+"*1"));
            return Float.parseFloat(mm);

        } catch (NumberFormatException | NullPointerException ex) {

            System.out.println("Error evaluating function: " + ex.getMessage());
            return Float.NaN;
        } catch (Exception e) {
            System.out.println("Something unexpected occured");
            return Float.NaN;
        }

    }

    public void switchMode(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        Stage st = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        st.setScene(scene);
        st.show();
    }

    public void exitOut(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}
