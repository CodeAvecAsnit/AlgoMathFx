package org.example.modes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author : Asnit Bakhati
 */

public class MatrixEvaluatorController {

    @FXML
    public TextField a00;
    @FXML
    public TextField a01;
    @FXML
    public TextField a02;
    @FXML
    public TextField a03;
    @FXML
    public TextField a10;
    @FXML
    public TextField a11;
    @FXML
    public TextField a12;
    @FXML
    public TextField a13;
    @FXML
    public TextField a20;
    @FXML
    public TextField a21;
    @FXML
    public TextField a22;
    @FXML
    public TextField a23;
    @FXML
    public Label x1;
    @FXML
    public Label x2;
    @FXML
    public Label x3;
    @FXML
    AnchorPane Pane;


    public void Generate(ActionEvent e){
        double [][] k= new double[3][4];
        try {
            k[0][0] = Double.parseDouble(a00.getText());
            k[0][1] = Double.parseDouble(a01.getText());
            k[0][2] = Double.parseDouble(a02.getText());
            k[0][3] = Double.parseDouble(a03.getText());
            k[1][0] = Double.parseDouble(a10.getText());
            k[1][1] = Double.parseDouble(a11.getText());
            k[1][2] = Double.parseDouble(a12.getText());
            k[1][3] = Double.parseDouble(a13.getText());
            k[2][0] = Double.parseDouble(a20.getText());
            k[2][1] = Double.parseDouble(a21.getText());
            k[2][2] = Double.parseDouble(a22.getText());
            k[2][3] = Double.parseDouble(a23.getText());
            k=reduce(k);
            for(int i =0;i<3;++i){
                for (int j=0;j<4;++j){
                    System.out.print(k[i][j]+" ");
                }
                System.out.println();
            }
            x1.setText(String.valueOf(k[0][3]));
            x2.setText(String.valueOf(k[1][3]));
            x3.setText(String.valueOf(k[2][3]));
        }catch (Exception ex){
            showAlert();
        }

    }

    public void Switch_mode(ActionEvent e)throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Exit(ActionEvent e){
        Stage st = (Stage) Pane.getScene().getWindow();
        st.close();
    }

    public void Clear(ActionEvent e){
        a00.setText("");
        a01.setText("");
        a02.setText("");
        a03.setText("");
        a10.setText("");
        a11.setText("");
        a12.setText("");
        a13.setText("");
        a20.setText("");
        a21.setText("");
        a22.setText("");
        a23.setText("");
        x1.setText("");
        x2.setText("");
        x3.setText("");

    }

    double[][] reduce(double[][] a){
        for(int i = 0; i < 3; ++i) {

            double pivot = a[i][i];
            for(int j = i; j < 4; ++j) {
                if(pivot!=0) a[i][j] /= pivot;
            }

            for(int k = 0; k < 3; ++k) {
                if(k != i) {
                    double factor = a[k][i];
                    for(int j = 0; j < 4; ++j) {
                        a[k][j] -= factor * a[i][j];
                    }
                }
            }
        }
        return a;
    }
    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText("Enter valid Inputs");
        alert.showAndWait();
    }
}
