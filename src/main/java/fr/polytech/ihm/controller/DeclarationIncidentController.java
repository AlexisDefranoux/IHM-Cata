package fr.polytech.ihm.controller;

import fr.polytech.ihm.Animation;
import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.Session;
import fr.polytech.ihm.model.enums.Categorie;
import fr.polytech.ihm.model.enums.Etat;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private ComboBox<Integer> idHeure;

    @FXML
    private ComboBox<Integer> idMin;

    @FXML
    private Button idAnnuler;

    @FXML
    private Button idValider;

    @FXML
    private CheckBox idUrgence;

    @FXML
    private Text iderreur;

    @FXML
    public void initialize(){

        initCombobox();

        idAnnuler.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                backToHome(event,idAnnuler);
            }
        });

        idValider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if(!idTitre.getText().isEmpty() && !idLocalisation.getText().isEmpty()){


                    String titre = idTitre.getText();
                    String description = idDescription.getText();
                    Categorie categorie = idCategorie.getSelectionModel().getSelectedItem();
                    String localisation = idLocalisation.getText();
                    Date date = new Date();
                    boolean importance = idUrgence.isSelected();
                    String auteur = Session.getInstance().getEmail();

                    Incident incident = new Incident(titre, description, categorie, localisation, date, importance, auteur);
                    System.out.println(incident.toString());
                    backToHome(event,idValider);
                }else{
                    Thread titreThread = new Thread(new Animation(idTitre));
                    Thread localisationThread = new Thread(new Animation(idLocalisation));
                    if(idTitre.getText().isEmpty()){
                        idTitre.setStyle("-fx-border-color: red");
                        titreThread.start();
                    }else{
                        idTitre.setStyle("-fx-border-color: rgb(186,186,186)");
                    }

                    if(idLocalisation.getText().isEmpty()){
                        idLocalisation.setStyle("-fx-border-color: red");
                        localisationThread.start();
                    }else{
                        idLocalisation.setStyle("-fx-border-color: rgb(186,186,186)");
                    }
                    iderreur.setVisible(true);
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

    private void initCombobox(){
        Date actuelle = new Date();
        DateFormat minuteFormat =  new SimpleDateFormat("m");
        int min = Integer.parseInt(minuteFormat.format(actuelle));

        for(int i=0; i<24; i++){
            idHeure.getItems().add(i);
        }
        for(int i=0; i<60; i+=5){
            idMin.getItems().add(i);
            if(min-i<5 && min-i>=0)
                idMin.setValue(i);
        }
        for(Categorie c : Categorie.values()){
            idCategorie.getItems().add(c);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(actuelle);
        idDate.getEditor().setText(dat);

        DateFormat heurFormat = new SimpleDateFormat("H");
        String hour = heurFormat.format(actuelle);
        System.out.println(hour);
        idHeure.setValue(Integer.parseInt(hour));
    }

}
