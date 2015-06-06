package de.wagnst.tpe.exercise.swingOberflaeche;

import javax.swing.*;

/**
 * main class to launch the application
 * 
 * @author Max
 *
 */
public class Main {
    public static void main(String[] args) {

        /* setting for Enigma */
        JFrame cryptoFenster = new Enigma();
        cryptoFenster.setSize(700, 400);
        cryptoFenster.setLocationRelativeTo(null);
        cryptoFenster.setVisible(true);
    }

}
