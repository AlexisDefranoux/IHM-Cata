package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

}
