package fr.polytech.ihm.model.enums;

public enum Categorie {
    MENAGE("Ménage"), REPARER("Réparer"), AUTRE("Autre");

    private String string;

    Categorie(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
