package org.example.modes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.modes.utils.Calculator;

import java.io.IOException;
import java.util.Objects;

/**
 * @author : Asnit Bakhati
 */
public class CalculatorController {

    private final Calculator calculator = new Calculator();


    private final StringBuilder calcText = new StringBuilder();

    @FXML
    public AnchorPane pane;

    @FXML
    public Stage stage;

    @FXML
    public TextArea ta;

    @FXML
    public Button one,two,three,four,five,six,seven,eight,nine,zero;

    @FXML
    public Button plus,minus,multiply,divide,bracket1,bracket2,calc,power,delete,clear;


    public void deleteLast(ActionEvent e){
        if(!calcText.isEmpty()){
            calcText.setLength(calcText.length()-1);
        }
        calcTextOnScreen();
    }


    public void Clear(ActionEvent e){
        calcText.setLength(0);
        calcTextOnScreen();
    }


    public void power(ActionEvent e){
        calcText.append("^");
        calcTextOnScreen();
    }


    public void setOne(ActionEvent e){
        calcText.append("1");
        calcTextOnScreen();
    }


    public void setTwo(ActionEvent e){
        calcText.append("2");
        calcTextOnScreen();
    }

    public void setThree(ActionEvent e){
        calcText.append("3");
        calcTextOnScreen();
    }

    public void setFour(ActionEvent e){
        calcText.append("4");
        calcTextOnScreen();
    }


    public void setFive(ActionEvent e){
        calcText.append("5");
        calcTextOnScreen();
    }

    public void setSix(ActionEvent e){
        calcText.append("6");
        calcTextOnScreen();
    }

    public void setSeven(ActionEvent e){
        calcText.append("7");
        calcTextOnScreen();
    }

    public void setEight(ActionEvent e){
        calcText.append("8");
        calcTextOnScreen();
    }

    public void setNine(ActionEvent e){
        calcText.append("9");
        calcTextOnScreen();
    }

    public void setZero(ActionEvent e){
        calcText.append("0");
        calcTextOnScreen();
    }

    public void setPlus(ActionEvent e){
        calcText.append("+");
        calcTextOnScreen();
    }
    public void setMinus(ActionEvent e){
        calcText.append("-");
        calcTextOnScreen();
    }
    public void setMultiply(ActionEvent e){
        calcText.append("*");
        calcTextOnScreen();
    }
    public void setDivide(ActionEvent e){
        calcText.append("/");
        calcTextOnScreen();
    }
    public void setBracket1(ActionEvent e){
        calcText.append("(");
        calcTextOnScreen();
    }

    public void setBracket2n(ActionEvent e){
        calcText.append(")");
        calcTextOnScreen();
    }


    public void setCalc(ActionEvent e){
        try {
            String calculatedResult = String.valueOf(calculator.calculate(ta.getText()+"*1"));
            calcText.setLength(0);
            calcText.append(calculatedResult);
            System.out.println(calculatedResult);
            ta.setText(calculatedResult);
        }catch (Exception exception){
            ta.setText("Error");
        }
    }

    public void switchMode(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        Stage st = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        st.setScene(scene);
        st.show();
    }

    public void exit(ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("exitOut");
        alert.setContentText("Are you sure you want to exit?");
        if(alert.showAndWait().get()== ButtonType.OK) {
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
        }
    }

    private void calcTextOnScreen(){
        ta.setText(calcText.toString());
    }
}