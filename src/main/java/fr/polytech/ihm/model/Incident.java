package fr.polytech.ihm;

import fr.polytech.ihm.model.enums.Categorie;
import fr.polytech.ihm.model.enums.Etat;

import java.util.Date;

public class Incident {

    private String titre;
    private String description;
    private Categorie categorie;
    private String localisation;
    private Date dateMishap;
    private Date dateDeclaration;
    private String importance;
    private String auteur;
    private Etat etat;

    public Incident(String titre, String description, Categorie categorie, String localisation, Date dateMishap, Date dateDeclaration, String importance, String auteur, Etat etat) {
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
        this.localisation = localisation;
        this.dateMishap = dateMishap;
        this.dateDeclaration = dateDeclaration;
        this.importance = importance;
        this.auteur = auteur;
        this.etat = etat;
    }
}
