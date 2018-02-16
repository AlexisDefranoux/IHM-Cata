package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Session;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class HomeController {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> clnDate;

    @FXML
    private TableColumn<?, ?> clnImportance;

    @FXML
    private TableColumn<?, ?> clnTitre;

    @FXML
    private TableColumn<?, ?> clnCategorie;

    @FXML
    private TableColumn<?, ?> clnLieu;

    @FXML
    private TableColumn<?, ?> clnDescription;

    @FXML
    private TableColumn<?, ?> clnDate1;

    @FXML
    private Button btnDeclarerIncident;

    @FXML
    private Button btnRechercher;

    @FXML
    private Hyperlink lienDeconnexion;

    @FXML
    private Text login;

    public void initialize(){
        String temp = Session.getInstance().getEmail();
        login.setText(temp);

        btnDeclarerIncident.setOnMouseClicked(event -> {
            FXMLLoader loader = new FXMLLoader();
            try {
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream("/fxml/declarationIncident.fxml"));
                Scene scene = new Scene(rootNode);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        lienDeconnexion.setOnMouseClicked(event -> {
            FXMLLoader loader = new FXMLLoader();
            try {
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream("/fxml/connexion.fxml"));
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
