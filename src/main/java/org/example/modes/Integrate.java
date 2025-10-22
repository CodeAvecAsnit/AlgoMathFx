package org.example.modes;

import javafx.event.ActionEvent;
import Calculate.CalculatorProgram;
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

public class Integrate {

    CalculatorProgram anchor = new CalculatorProgram();

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

    private Stage stage;
    private Stage st;
    private Scene scene;
    private Parent root;

    public void find(ActionEvent e) {
        try {
            float high = Float.parseFloat(upper.getText());
            float low = Float.parseFloat(lower.getText());
            String func = Function.getText();

            float I = Integration(high, low, func);
            System.out.println(I);

            answer.setText(String.valueOf(I));

            upper.clear();
            lower.clear();
            Function.clear();
        } catch (NumberFormatException ex) {
            answer.setText("Invalid input. Please enter numeric values.");
        }
    }

    public float Integration(float high, float low, String func) {
        try {
            float integral = floater(func, low) + floater(func, high);
            float diff = (high - low) / 128;

            for (int i = 1; i < 128; ++i) {
                if (i % 3 == 0) {
                    integral += 2 * floater(func, (low + diff * i));
                } else {
                    integral += 3 * floater(func, (low + diff * i));
                }
            }

            integral *= (3 * diff) / 8;
            return integral;

        } catch (NumberFormatException | NullPointerException ex) {
            System.out.println("Error evaluating function: " + ex.getMessage());
            return Float.NaN;
        }
    }

    public float floater(String fc, float x) {
        CalculatorProgram anchor = new CalculatorProgram();
        try {
            fc = fc.replace("x", String.valueOf(x));
            fc = fc.replace("X", String.valueOf(x));

            String mm = anchor.Calculator_program(fc+"*1");
            return Float.parseFloat(mm);

        } catch (NumberFormatException | NullPointerException ex) {

            System.out.println("Error evaluating function: " + ex.getMessage());
            return Float.NaN;
        }
    }

    public void switch_Mode(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        st = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        st.setScene(scene);
        st.show();
    }

    public void Exit(ActionEvent event) {
        stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}
