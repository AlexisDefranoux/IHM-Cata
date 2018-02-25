package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.Incidents;
import fr.polytech.ihm.model.Session;
import fr.polytech.ihm.model.enums.Categorie;
import fr.polytech.ihm.model.enums.Colone;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    private String recherche = "";
    private boolean mesIncident = false;

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

    @FXML
    private ComboBox<String> comboCol;

    public void initialize(){

        for(Colone colone : Colone.values()){
            comboCol.getItems().add(colone.getName());
        }
        comboCol.setValue("Titre");

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

        Incidents.getInstance().getIncidentsAfficher().clear();
        Incidents.getInstance().getIncidentsAfficher().addAll(Incidents.getInstance().getIncidentsAll());

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
           recherche = inputRecherche.getText();
           Incidents.getInstance().getIncidentsAfficher().clear();
           Incidents.getInstance().getIncidentsAll().stream().filter(incident ->
                   recherche(incident) && (!mesIncident || incident.getAuteur().equals(Session.getInstance().getEmail()))
           ).forEach(incident ->  Incidents.getInstance().getIncidentsAfficher().add(incident));
        });

        inputRecherche.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                recherche = inputRecherche.getText();
                if(recherche.isEmpty()){
                    for(Incident incident : Incidents.getInstance().getIncidentsAll()){
                        if((!mesIncident || incident.getAuteur().equals(Session.getInstance().getEmail())) && !Incidents.getInstance().getIncidentsAfficher().contains(incident))
                            Incidents.getInstance().getIncidentsAfficher().add(incident);
                    }
                }
            }
        });
        mesIncidents.setOnMouseClicked(event ->{
            mesIncident = mesIncidents.isSelected();
            if(mesIncident){
                Incidents.getInstance().getIncidentsAfficher().removeIf( incident -> !incident.getAuteur().equals(Session.getInstance().getEmail()));
            }else{
                for(Incident incident : Incidents.getInstance().getIncidentsAll()){
                    if((recherche.isEmpty() || incident.getTitreString().toUpperCase().contains(recherche.toUpperCase())) && !Incidents.getInstance().getIncidentsAfficher().contains(incident))
                        Incidents.getInstance().getIncidentsAfficher().add(incident);
                }
            }
        });

    }
    private boolean recherche(Incident incident){

        switch (comboCol.getSelectionModel().getSelectedItem()){
            case "Titre":
                return incident.getTitreString().toUpperCase().contains(recherche.toUpperCase());
            case "Catégorie":
                return incident.getCategorieString().toUpperCase().contains(recherche.toUpperCase());
            case "Lieu":
                return incident.getLocalisation().toString().toUpperCase().contains(recherche.toUpperCase());
            case "Description":
                return incident.getDescription().toString().toUpperCase().contains(recherche.toUpperCase());
            default:
                return incident.getTitreString().toUpperCase().contains(recherche.toUpperCase());
        }


    }

}
