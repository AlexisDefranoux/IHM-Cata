package fr.polytech.ihm;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.Incidents;
import fr.polytech.ihm.model.enums.Categorie;
import fr.polytech.ihm.model.enums.Etat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        new Incident("Fuite aux toilettes", "Il y a une fuite d'eau dans les toilettes des filles", Categorie.REPARER, "Batiment O, étage 2", new Date("11/05/08"), true, "jean-francois@etu-unice.fr", Etat.TERMINER);
        new Incident("Vitre cassé", "Il y a une vitre cassée dans la salle de cours. Il fait froid.", Categorie.REPARER, "E-103", new Date("08/11/05"), false, "jean-francois@etu-unice.fr", Etat.ENCOURS);
        new Incident("Café renversé", "J'ai renversé mon café en amphi.", Categorie.MENAGE, "Amphithéatre Nord", new Date("02/03/04"), false, "jean-francois@etu-unice.fr", Etat.NONTRAITE);
        new Incident("Imprimante cassée", "L'imprimante ne fonctionne plus", Categorie.AUTRE, "Batiment O", new Date(), true, "jean-paul@etu-unice.fr", Etat.ENCOURS);

        log.info("Starting Hello JavaFX and Maven demonstration application");

        String fxmlFile = "/fxml/connexion.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
       Scene scene = new Scene(rootNode, 900, 600);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setResizable(false);

        stage.setTitle("Service de déclaration d'incidents");
        stage.setScene(scene);
        stage.show();
    }
}
