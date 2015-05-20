package de.wagnst.tpe.exercise.swing;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Fenster öffnen und darstellen
        JFrame CryptoFenster = new Hauptansicht();

        // Fensterhöhe und -breite in Pixeln
        CryptoFenster.setSize(500, 300);

        // Fenster in Bildschirmmitte
        CryptoFenster.setLocationRelativeTo(null);

        // Sichtbar machen
        CryptoFenster.setVisible(true);

    }

}
