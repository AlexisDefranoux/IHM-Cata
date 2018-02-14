package fr.polytech.ihm.model.enums;

public enum Categorie {
    MENAGE("Ménage"), REPARER("Réparer"), AUTRE("Autre");

    private String name;

    Categorie(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
