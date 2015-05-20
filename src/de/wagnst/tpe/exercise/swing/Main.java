package de.wagnst.tpe.exercise.swing;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // opens window
        JFrame CryptoFenster = new Hauptansicht();

        // window size (h/w)
        CryptoFenster.setSize(500, 300);

        // window position center
        CryptoFenster.setLocationRelativeTo(null);

        // set it visible
        CryptoFenster.setVisible(true);

    }

}
