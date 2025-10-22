package org.example.modes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


/**
 * @author : Asnit Bakhati
 */

public class EquationEvaluator {


    @FXML
    public AnchorPane pane;

    private Stage st;
    private Scene scene;
    private Parent root;

    @FXML
    public void get_now(ActionEvent e){
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

    public void Screen1(ActionEvent e) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Screen1.fxml")));
        st=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st.setScene(scene);
        st.show();
    }

    public void Screen2(ActionEvent e) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Screen2.fxml")));
        st=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st.setScene(scene);
        st.show();
    }

    public void swagger(ActionEvent e) throws IOException {
        root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mode.fxml")));
        st=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        st.setScene(scene);
        st.setResizable(true);
        st.show();
    }
}
