package fr.polytech.ihm.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
        btnValider.setOnMouseClicked(new EventHandler<MouseEvent>() {
             public void handle(MouseEvent event) {
                 backToHome(event,btnValider);
             }
         });
    }
    private void backToHome(MouseEvent event,Button btn){
        if (event.getButton() == MouseButton.PRIMARY) {
            String fxmlFile = "/fxml/home.fxml";
            FXMLLoader loader = new FXMLLoader();
            try {
                Stage stage = (Stage) btn.getScene().getWindow();
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                Scene scene = new Scene(rootNode);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
