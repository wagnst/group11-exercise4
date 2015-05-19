package de.wagnst.tpe.exercise.swing;

import java.awt.event.*;

import de.wagnst.tpe.exercise.subsitutionschiffre.*;
import de.wagnst.tpe.exercise.crypter.*;

import javax.swing.*;

public class SubstiEncoderActionListener implements ActionListener {

    private JTextField messageField = new JTextField();
    private JTextField keyField = new JTextField();
    private JTextField encodeField = new JTextField();

    public SubstiEncoderActionListener(JTextField messageField, JTextField keyField,
            JTextField encodeField) {
        this.messageField = messageField;
        this.keyField = keyField;
        this.encodeField = encodeField;
    }

    public void actionPerformed(ActionEvent event) {

        Crypter enigma = new Substi();

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

    }
}
