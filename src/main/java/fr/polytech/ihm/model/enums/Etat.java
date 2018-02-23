package fr.polytech.ihm.model.enums;

public enum Etat {
    NONTRAITE("Non traiter"), ENCOURS("En cours"), TERMINER("Terminer");

    private String name;

    Etat(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
