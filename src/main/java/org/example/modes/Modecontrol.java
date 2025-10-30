package org.example.modes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;


public class Modecontrol{

    @FXML
    public Button exit;
    @FXML
    public AnchorPane pane;
    Stage stage;

    private Stage st1;
    private Scene scene;
    private Parent root;

    public void calculatorPage(ActionEvent e)throws IOException{
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CalculatorController.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.show();

    }
    public void equationPage(ActionEvent e)throws IOException{
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EquationEvaluator.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.show();
    }

    public void integrationPage(ActionEvent e) throws IOException{
        stage =(Stage)pane.getScene().getWindow();
        stage.close();
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("IntegrationController.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.setResizable(true);
        st1.show();

    }

    public void matrixPage(ActionEvent e)throws IOException{
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MatrixEvaluatorController.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.show();
    }

    public void exitOut(ActionEvent e){
        stage =(Stage)pane.getScene().getWindow();
        stage.close();
    }

    public void lastOne(ActionEvent e)throws IOException{
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterpolationController.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.show();
    }

}