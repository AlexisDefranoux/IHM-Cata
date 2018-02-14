package fr.polytech.ihm.model;

public class Session {

    private static String email;
    private static Session ourInstance = new Session(email);

    public static Session getInstance() {
        return ourInstance;
    }

    private Session(String email) {
        this.email = email;
    }
}
