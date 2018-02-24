package fr.polytech.ihm.model.enums;

public enum Colone {
    TITRE("Titre"),
    CATEGORIE("Catégorie"),
    LIEU("Lieu"),
    DESCRIPTION("Description");

    private String name;
    Colone(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
