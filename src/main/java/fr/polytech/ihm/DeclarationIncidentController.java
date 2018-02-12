package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeclarationIncidentController {
    private static final Logger log = LoggerFactory.getLogger(DeclarationIncidentController.class);

    @FXML
    private TextField idTitre;

    @FXML
    private TextArea idDescription;

    @FXML
    private ComboBox<?> idCategorie;

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

    }

}
