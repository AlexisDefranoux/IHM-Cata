package fr.polytech.ihm.model.enums;

public enum Colonne {
    TITRE("Titre"),
    CATEGORIE("Catégorie"),
    LIEU("Lieu"),
    DESCRIPTION("Description");

    private String name;
    Colonne(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
