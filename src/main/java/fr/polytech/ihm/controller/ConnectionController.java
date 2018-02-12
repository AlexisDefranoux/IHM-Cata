package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ConnectionController {

    @FXML
    private Button btnValider;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMdp;

    public void initialize(){
        btnValider.setOnMouseClicked(event -> {
            FXMLLoader loader = new FXMLLoader();
            try {
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream("/fxml/home.fxml"));
                Scene scene = new Scene(rootNode);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
