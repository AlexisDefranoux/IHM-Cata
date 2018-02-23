package fr.polytech.ihm.model.enums;

public enum Etat {
    NONTRAITE("Non traité"), ENCOURS("En cours"), TERMINER("Terminé");

    private String name;

    Etat(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
