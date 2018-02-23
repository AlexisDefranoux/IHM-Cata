package fr.polytech.ihm;

import javafx.scene.control.TextField;

public class Animation implements Runnable {
    private TextField textField;

    public Animation(TextField textField){
        this.textField = textField;
    }

    @Override
    public void run() {
        int compteur = 0;
        while(compteur < 20){
            compteur++;
            textField.setTranslateX(3);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            textField.setTranslateX(-3);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
