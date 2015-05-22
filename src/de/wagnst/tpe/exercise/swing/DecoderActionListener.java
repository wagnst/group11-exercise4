package de.wagnst.tpe.exercise.swing;

import de.wagnst.tpe.exercise.crypter.Crypter;
import de.wagnst.tpe.exercise.crypter.CrypterVerfahren;
import de.wagnst.tpe.exercise.crypter.IllegalKeyException;
import de.wagnst.tpe.exercise.crypter.IllegalMessageException;
import de.wagnst.tpe.exercise.subsitutionschiffre.CrypterSubstitution;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecoderActionListener implements ActionListener {

    private JTextArea messageField = new JTextArea();
    private JTextField keyField = new JTextField();
    private JTextArea encodeField = new JTextArea();
    private JComboBox selectedCrypter;

    public DecoderActionListener(JTextArea messageField,
                                 JTextField keyField,
                                 JTextArea encodeField,
                                 JComboBox selectedCrypter) {
        this.messageField = messageField;
        this.keyField = keyField;
        this.encodeField = encodeField;
        this.selectedCrypter = selectedCrypter;
    }

    public void actionPerformed(ActionEvent event) {

        if (selectedCrypter.getSelectedItem().equals(
                CrypterVerfahren.SUBSTITUTION.getName())) {
            Crypter enigma = new CrypterSubstitution();
            try {
                encodeField.setText(enigma.entschluesseln(keyField.getText(),
                        messageField.getText()));
            } catch (IllegalKeyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (IllegalMessageException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        } else if (selectedCrypter.getSelectedItem().equals(
                CrypterVerfahren.CAESAR.getName())) {
            JOptionPane.showMessageDialog(null, "CAESAR");
        } else if (selectedCrypter.getSelectedItem().equals(
                CrypterVerfahren.XOR.getName())) {
            JOptionPane.showMessageDialog(null, "XOR");
        }
    }
}