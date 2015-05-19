package de.wagnst.tpe.exercise.swing;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Fenster öffnen und darstellen
        JFrame loginFenster = new Hauptansicht();

        // Fensterhöhe und -breite in Pixeln
        loginFenster.setSize(500, 300);

        // Fenster in Bildschirmmitte
        loginFenster.setLocationRelativeTo(null);

        loginFenster.setVisible(true);
        
        

    }

}
