package de.wagnst.tpe.exercise.swingOberflaeche;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        /*
        JFrame cryptoFenster = new HauptansichtDoof();
        cryptoFenster.setSize(500, 300); // window position
        cryptoFenster.setLocationRelativeTo(null); // set it visible
        cryptoFenster.setVisible(true);
        */

        /* setting for Enigma */
        JFrame cryptoFenster = new Enigma();
        cryptoFenster.setSize(700, 400);
        cryptoFenster.setLocationRelativeTo(null);
        cryptoFenster.setVisible(true);
    }

}
