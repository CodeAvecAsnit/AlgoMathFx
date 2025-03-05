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
    public void calculator(ActionEvent e)throws IOException{
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Calculator.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.show();

    }
    public void equation(ActionEvent e)throws IOException{
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Eqmode.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.show();
    }
    public void Integration(ActionEvent e) throws IOException{
        stage =(Stage)pane.getScene().getWindow();
        stage.close();
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Integrate.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.setResizable(true);
        st1.show();

    }

    public void Matrix(ActionEvent e)throws IOException{
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Matrix.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.show();
    }
    public void Exit(ActionEvent e){
        stage =(Stage)pane.getScene().getWindow();
        stage.close();
    }
    public void Lastone(ActionEvent e)throws IOException{
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Inter.fxml")));
        st1=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st1.setScene(scene);
        st1.show();

    }

}