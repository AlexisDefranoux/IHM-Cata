package fr.polytech.ihm.model;

import fr.polytech.ihm.model.enums.Categorie;
import fr.polytech.ihm.model.enums.Etat;

import java.util.Date;
import java.util.Objects;

public class Incident {

    private String titre;
    private String description;
    private Categorie categorie;
    private String localisation;
    private Date dateMishap;
    private Date dateDeclaration;
    private boolean importance;
    private String auteur;
    private Etat etat;

    public Incident(String titre, String description, Categorie categorie, String localisation, Date dateDeclaration, boolean importance, String auteur) {
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
        this.localisation = localisation;
        this.dateMishap = new Date();
        this.dateDeclaration = dateDeclaration;
        this.importance = importance;
        this.auteur = auteur;
        this.etat = Etat.declaration;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String getLocalisation() {
        return localisation;
    }

    public Date getDateMishap() {
        return dateMishap;
    }

    public Date getDateDeclaration() {
        return dateDeclaration;
    }

    public boolean getImportance() {
        return importance;
    }

    public String getAuteur() {
        return auteur;
    }

    public Etat getEtat() {
        return etat;
    }
    @Override
    public String toString() {
        return "Incident{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", categorie=" + categorie +
                ", localisation='" + localisation + '\'' +
                ", dateMishap=" + dateMishap +
                ", dateDeclaration=" + dateDeclaration +
                ", importance='" + importance + '\'' +
                ", auteur='" + auteur + '\'' +
                ", etat=" + etat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incident incident = (Incident) o;
        return Objects.equals(titre, incident.titre) &&
                Objects.equals(description, incident.description) &&
                categorie == incident.categorie &&
                Objects.equals(localisation, incident.localisation) &&
                Objects.equals(dateMishap, incident.dateMishap) &&
                Objects.equals(dateDeclaration, incident.dateDeclaration) &&
                Objects.equals(importance, incident.importance) &&
                Objects.equals(auteur, incident.auteur) &&
                etat == incident.etat;
    }

    @Override
    public int hashCode() {

        return Objects.hash(titre, description, categorie, localisation, dateMishap, dateDeclaration, importance, auteur, etat);
    }
}
