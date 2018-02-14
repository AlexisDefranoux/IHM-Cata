package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.enums.Categorie;
import fr.polytech.ihm.model.enums.Etat;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

public class DeclarationIncidentController {
    private static final Logger log = LoggerFactory.getLogger(DeclarationIncidentController.class);

    @FXML
    private TextField idTitre;

    @FXML
    private TextArea idDescription;

    @FXML
    private ComboBox<Categorie> idCategorie;

    @FXML
    private TextField idLocalisation;

    @FXML
    private DatePicker idDate;

    @FXML
    private ComboBox<?> idHeure;

    @FXML
    private ComboBox<?> idMin;

    @FXML
    private Button idAnnuler;

    @FXML
    private Button idValider;

    @FXML
    private Slider idImportance;

    @FXML
    public void initialize(){
        idAnnuler.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                backToHome(event,idAnnuler);
            }
        });
        idValider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                String titre = idTitre.getText();
                String description = idDescription.getText();
                Categorie categorie = idCategorie.getSelectionModel().getSelectedItem();
                String localisation = idLocalisation.getText();
                Date date = new Date();
                String importance = "faible";
                Etat etat = Etat.declaration;

                if(titre != ""){
                    Incident incident = new Incident(titre, description, categorie, localisation, date, date,
                            importance,"Auteur",etat);

                    backToHome(event,idValider);
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
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
