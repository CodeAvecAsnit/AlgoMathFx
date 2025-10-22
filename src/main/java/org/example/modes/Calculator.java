package org.example.modes;
import Calculate.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author : Asnit Bakhati
 */
public class Calculator {

    private final CalculatorProgram jacket=new CalculatorProgram();

    String main="";

    @FXML
    AnchorPane pane;

    Stage stage;

    @FXML
    public TextArea ta;

    @FXML
    public Button one;

    @FXML
    public Button two;

    @FXML
    public Button three;

    @FXML
    public Button four;

    @FXML
    public Button five;

    @FXML
    public Button six;

    @FXML
    public Button seven;

    @FXML
    public Button eight;

    @FXML
    public Button nine;

    @FXML
    public Button zero;

    @FXML
    public Button plus;

    @FXML
    public Button minus;

    @FXML
    public Button multiply;

    @FXML
    public Button divide;


    @FXML
    public Button bracket1;

    @FXML
    public Button bracket2;

    @FXML
    public Button calc;


    @FXML
    public Button power;

    @FXML
    public Button delete;

    @FXML
    public Button clear;


    public void deletelast(ActionEvent e){
        if(!main.isEmpty()){
            main=main.substring(0,main.length()-1);
        }
        ta.setText(main);
    }



    public void Clear(ActionEvent e){
        main="";
        ta.setText("");
    }


    public void power(ActionEvent e){
        main=main+"^";
        ta.setText(main);
    }




    public void setOne(ActionEvent e){
        main=main+"1";
        ta.setText(main);
    }


    public void setTwo(ActionEvent e){
        main=main+"2";
        ta.setText(main);
    }


    public void setThree(ActionEvent e){
        main=main+"3";
        ta.setText(main);
    }

    public void setFour(ActionEvent e){
        main=main+"4";
        ta.setText(main);
    }


    public void setFive(ActionEvent e){
        main=main+"5";
        ta.setText(main);
    }

    public void setSix(ActionEvent e){
        main=main+"6";
        ta.setText(main);
    }

    public void setSeven(ActionEvent e){
        main=main+"7";
        ta.setText(main);
    }

    public void setEight(ActionEvent e){
        main=main+"8";
        ta.setText(main);
    }

    public void setNine(ActionEvent e){
        main=main+"9";
        ta.setText(main);
    }

    public void setZero(ActionEvent e){
        main=main+"0";
        ta.setText(main);
    }

    public void setPlus(ActionEvent e){
        main=main+"+";
        ta.setText(main);
    }
    public void setMinus(ActionEvent e){
        main=main+"-";
        ta.setText(main);
    }
    public void setMultiply(ActionEvent e){
        main=main+"*";
        ta.setText(main);
    }
    public void setDivide(ActionEvent e){
        main=main+"/";
        ta.setText(main);
    }
    public void setBracket1(ActionEvent e){
        main=main+"(";
        ta.setText(main);
    }

    public void setBracket2n(ActionEvent e){
        main=main+")";
        ta.setText(main);
    }


    public void setCalc(ActionEvent e){
        try {
            String res = jacket.Calculator_program(ta.getText()+"*1");
            main=res;
            System.out.println(res);
            ta.setText(res);
        }catch (Exception exception){
            ta.setText("Error");
        }
    }



    public void Switch_md(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        Stage st = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        st.setScene(scene);
        st.show();
    }



    public void exit(ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setContentText("Are you sure you want to exit?");
        if(alert.showAndWait().get()== ButtonType.OK) {
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
        }
    }
}