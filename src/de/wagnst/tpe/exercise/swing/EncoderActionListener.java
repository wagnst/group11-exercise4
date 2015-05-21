package de.wagnst.tpe.exercise.swing;

import de.wagnst.tpe.exercise.crypter.Crypter;
import de.wagnst.tpe.exercise.crypter.IllegalKeyException;
import de.wagnst.tpe.exercise.crypter.IllegalMessageException;
import de.wagnst.tpe.exercise.subsitutionschiffre.CrypterSubstitution;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncoderActionListener implements ActionListener {

    private JTextArea messageField = new JTextArea();
    private JTextArea keyField = new JTextArea();
    private JTextArea encodeField = new JTextArea();
    private JComboBox selectedCrypter;

    public EncoderActionListener(JTextArea messageField,
                                 JTextArea keyField,
                                 JTextArea encodeField,
                                 JComboBox selectedCrypter) {
        this.messageField = messageField;
        this.keyField = keyField;
        this.encodeField = encodeField;
        this.selectedCrypter = selectedCrypter;
    }

    public void actionPerformed(ActionEvent event) {

        if (selectedCrypter.getSelectedItem().equals("SUBSTITUTION")) {
            Crypter enigma = new CrypterSubstitution();
            try {
                encodeField.setText(enigma.verschluesseln(keyField.getText(),
                        messageField.getText()));
            } catch (IllegalKeyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (IllegalMessageException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        } else if (selectedCrypter.getSelectedItem().equals("CAESAR")) {
            JOptionPane.showMessageDialog(null, "CAESAR");
        } else if (selectedCrypter.getSelectedItem().equals("XOR")) {
            JOptionPane.showMessageDialog(null, "XOR");
        }
    }
}