package fr.polytech.ihm.controller;

import fr.polytech.ihm.Animation;
import fr.polytech.ihm.model.Session;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class ConnectionController {

    @FXML
    private Button btnValider;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMdp;

    @FXML
    private Text ErreurLogin;

    public void initialize(){

        btnValider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                 if(!txtEmail.getText().isEmpty() && !txtMdp.getText().isEmpty()){
                     Session.getInstance().setEmail(txtEmail.getText());
                     backToHome(event,btnValider);
                 }else{
                     if(txtEmail.getText().isEmpty()){
                         txtEmail.setStyle("-fx-border-color: red");
                         Thread t = new Thread(new Animation(txtEmail));
                         t.start();
                     }else{
                         txtEmail.setStyle("-fx-border-color: rgb(186,186,186)");
                     }

                     if(txtMdp.getText().isEmpty()){
                         txtMdp.setStyle("-fx-border-color: red");
                         Thread t = new Thread(new Animation(txtMdp));
                         t.start();
                     }else{
                         txtMdp.setStyle("-fx-border-color: rgb(186,186,186)");
                     }
                     ErreurLogin.setVisible(true);
                 }
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
                scene.getStylesheets().add("/styles/styles.css");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
