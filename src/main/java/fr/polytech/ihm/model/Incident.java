package fr.polytech.ihm.model;

import fr.polytech.ihm.model.enums.Categorie;
import fr.polytech.ihm.model.enums.Etat;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Incident {

    private String titre;
    private String description;
    private Categorie categorie;
    private String localisation;
    private Date dateMishap;
    private Date dateDeclaration;
    private Boolean importance;
    private String auteur;
    private Etat etat;

    public Incident(String titre, String description, Categorie categorie, String localisation, Date dateDeclaration, boolean importance, String auteur, Etat etat) {
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
        this.localisation = localisation;
        this.dateMishap = new Date();
        this.dateDeclaration = dateDeclaration;
        this.importance = importance;
        this.auteur = auteur;
        this.etat = etat;
        Incidents.getInstance().addIncident(this);
    }

    public StringProperty getTitre() {
        return new SimpleStringProperty(titre);
    }
    public String getTitreString() {
        return titre;
    }


    public StringProperty getDescription() {
        if(description == null)
            return new SimpleStringProperty("");
        else
            return new SimpleStringProperty(description);
    }

    public StringProperty getCategorie() {
        if(categorie == null)
            return new SimpleStringProperty("");
        else
            return new SimpleStringProperty(categorie.toString());
    }

    public StringProperty getLocalisation() {
        return new SimpleStringProperty(localisation);
    }

    public StringProperty getDateMishap() {
        return new SimpleStringProperty(dateMishap.toString());
    }

    public StringProperty getDateDeclaration() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(dateDeclaration);

        DateFormat minuteFormat = new SimpleDateFormat("m");
        String m =(Integer.parseInt( minuteFormat.format(dateDeclaration))<10) ? "0"+ minuteFormat.format(dateDeclaration):minuteFormat.format(dateDeclaration);

        DateFormat heureFormat = new SimpleDateFormat("h");
        String h = (Integer.parseInt(heureFormat.format(dateDeclaration))<10) ? "0"+heureFormat.format(dateDeclaration):heureFormat.format(dateDeclaration);

        return new SimpleStringProperty(dat+"-"+h+":"+m);
    }

    public StringProperty getImportance() {
        if(importance)
            return new SimpleStringProperty("Urgent");
        else
            return new SimpleStringProperty("Aucune");
    }

    public String getAuteur() {
        return auteur;
    }

    public StringProperty getEtat() {
        return new SimpleStringProperty(etat.toString());
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
