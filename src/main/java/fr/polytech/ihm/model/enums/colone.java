package fr.polytech.ihm.model.enums;

public enum colone {
    TITRE("Titre"),
    CATEGORIE("Catégorie"),
    LIEU("Lieu"),
    DESCRIPTION("Description");

    private String name;
    colone(String name){
        this.name = name;
    }
}
