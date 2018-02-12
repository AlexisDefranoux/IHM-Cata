package fr.polytech.ihm;

import java.util.Date;

public class Incident {
    private String titre;
    private String description;
    private String categorie;
    private String localisation;
    private Date dateMishap;
    private Date dateDeclaration;
    private String importance;
    private String auteur;
    private String etat;

    public Incident(String titre, String description, String categorie, String localisation, Date dateMishap, Date dateDeclaration, String importance, String auteur, String etat) {
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
