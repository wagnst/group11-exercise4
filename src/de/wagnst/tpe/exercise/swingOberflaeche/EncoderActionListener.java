package de.wagnst.tpe.exercise.swingOberflaeche;

import de.wagnst.tpe.exercise.crypter.*;
import de.wagnst.tpe.exercise.crypters.CrypterFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncoderActionListener implements ActionListener {

    private JTextArea messageField = new JTextArea();
    private JTextField keyField = new JTextField();
    private JTextArea encodeField = new JTextArea();
    private JComboBox selectedCrypter;

    public EncoderActionListener(JTextArea messageField,
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
            try {
                Crypter substitution = CrypterFactory.createCrypter(CrypterVerfahren.SUBSTITUTION);
                encodeField.setText(substitution.verschluesseln(keyField.getText(),
                        messageField.getText()));
            } catch (IllegalKeyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (IllegalMessageException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (IllegalCrypterException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        } else if (selectedCrypter.getSelectedItem().equals(
                CrypterVerfahren.CAESAR.getName())) {
            try {
                Crypter caesar = CrypterFactory.createCrypter(CrypterVerfahren.CAESAR);
                encodeField.setText(caesar.verschluesseln(keyField.getText(),
                        messageField.getText()));
            } catch (IllegalKeyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (IllegalMessageException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (IllegalCrypterException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        } else if (selectedCrypter.getSelectedItem().equals(
                CrypterVerfahren.XOR.getName())) {
            try {
                Crypter xor = CrypterFactory.createCrypter(CrypterVerfahren.XOR);
                encodeField.setText(xor.verschluesseln(keyField.getText(),
                        messageField.getText()));
            } catch (IllegalKeyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (IllegalMessageException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (IllegalCrypterException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
