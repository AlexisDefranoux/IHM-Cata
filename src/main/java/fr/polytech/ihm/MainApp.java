package fr.polytech.ihm;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.Incidents;
import fr.polytech.ihm.model.enums.Categorie;
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
        new Incident("aitre", "descr", Categorie.MENAGE, "ma chambre", new Date(), false, "Moi");
        new Incident("titre2", "descr", Categorie.MENAGE, "ma chambre", new Date(), false, "Moi");
        new Incident("titre3", "descr", Categorie.MENAGE, "ma chambre", new Date(), false, "Moi");
        new Incident("aitrsqdsqe", "deqsdscr", Categorie.MENAGE, "ma chambrdqssqde", new Date(), false, "Mosdqdqsi");

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
