package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.Incidents;
import fr.polytech.ihm.model.Session;
import fr.polytech.ihm.model.enums.Categorie;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.IOException;
import java.util.Date;

public class HomeController {

    @FXML
    private TableView<Incident> table;

    @FXML
    private TableColumn<Incident, String> clnDate;

    @FXML
    private TableColumn<Incident, String> clnImportance;

    @FXML
    private TableColumn<Incident, String> clnTitre;

    @FXML
    private TableColumn<Incident, String> clnCategorie;

    @FXML
    private TableColumn<Incident, String> clnLieu;

    @FXML
    private TableColumn<Incident, String> clnDescription;

    @FXML
    private TableColumn<Incident, String> clnEtat;

    @FXML
    private Button btnDeclarerIncident;

    @FXML
    private TextField inputRecherche;

    @FXML
    private Button btnRechercher;

    @FXML
    private Hyperlink lienDeconnexion;

    @FXML
    private Text login;

    @FXML
    private CheckBox mesIncidents;

    public void initialize(){

        clnDate.setCellValueFactory(cellData -> cellData.getValue().getDateDeclaration());
        clnImportance.setCellValueFactory(cellData -> cellData.getValue().getImportance());
        clnTitre.setCellValueFactory(cellData -> cellData.getValue().getTitre());
        clnCategorie.setCellValueFactory(cellData -> cellData.getValue().getCategorie());
        clnLieu.setCellValueFactory(cellData -> cellData.getValue().getLocalisation());
        clnDescription.setCellValueFactory(cellData -> cellData.getValue().getDescription());
        clnEtat.setCellValueFactory(cellData -> cellData.getValue().getEtat());
        table.setItems(Incidents.getInstance().getIncidentsAfficher());

        String temp = Session.getInstance().getEmail();
        login.setText(temp);

        btnDeclarerIncident.setOnMouseClicked(event -> {
            FXMLLoader loader = new FXMLLoader();
            try {
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream("/fxml/declarationIncident.fxml"));
                Scene scene = new Scene(rootNode);
                scene.getStylesheets().add("/styles/styles.css");
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
                scene.getStylesheets().add("/styles/styles.css");
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnRechercher.setOnMouseClicked(event -> {
           String recherche = inputRecherche.getText();
           Incidents.getInstance().getIncidentsAfficher().clear();
           for(Incident incident : Incidents.getInstance().getIncidentsAll()){
                if(incident.getTitreString().contains(recherche)){
                    Incidents.getInstance().getIncidentsAfficher().add(incident);
                }
           }
        });


        mesIncidents.setOnMouseClicked(event ->{
            Incidents.getInstance().getIncidentsAfficher().clear();
            if(mesIncidents.isSelected()){
                for(Incident incident : Incidents.getInstance().getIncidentsAll()){
                    if(incident.getAuteur().contains(Session.getInstance().getEmail())){
                        Incidents.getInstance().getIncidentsAfficher().add(incident);
                    }
                }
            }else{
                for(Incident incident : Incidents.getInstance().getIncidentsAll()){
                    Incidents.getInstance().getIncidentsAfficher().add(incident);
                }
            }
        });



    }

}
