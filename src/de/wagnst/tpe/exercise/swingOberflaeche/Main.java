package de.wagnst.tpe.exercise.swingOberflaeche;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        /*
         * // opens window JFrame CryptoFenster = new HauptansichtDoof(); //
         * window size (w/h) CryptoFenster.setSize(500, 300); // window position
         * center CryptoFenster.setLocationRelativeTo(null); // set it visible
         * CryptoFenster.setVisible(true);
         */

        /* setting for Enigma */
        JFrame cryptoFenster = new Enigma();
        cryptoFenster.setSize(700, 400);
        cryptoFenster.setLocationRelativeTo(null);
        cryptoFenster.setVisible(true);
    }

}
