package de.wagnst.tpe.exercise.swing;

import java.awt.event.*;

import de.wagnst.tpe.exercise.subsitutionschiffre.*;
import de.wagnst.tpe.exercise.crypter.*;

import javax.swing.*;

public class SubstiDecoderActionListener implements ActionListener {

    private JTextArea messageField = new JTextArea();
    private JTextArea keyField = new JTextArea();
    private JTextArea encodeField = new JTextArea();

    public SubstiDecoderActionListener(JTextArea messageField,
            JTextArea keyField, JTextArea encodeField) {
        this.messageField = messageField;
        this.keyField = keyField;
        this.encodeField = encodeField;
    }

    public void actionPerformed(ActionEvent event) {

        Crypter enigma = new Substi();

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

    }
}