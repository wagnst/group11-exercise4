package de.wagnst.tpe.exercise.swing;

import de.wagnst.tpe.exercise.crypter.CrypterVerfahren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hauptansicht extends JFrame {

    private JTextArea messageField = new JTextArea();
    private JTextArea keyField = new JTextArea("DEFGHIJKLMNOPQRSTUVWXYZABC");
    private JTextArea codedField = new JTextArea();
    private JComboBox crypterList = new JComboBox(new String[] {
            CrypterVerfahren.SUBSTITUTION.getName(),
            CrypterVerfahren.CAESAR.getName(), CrypterVerfahren.XOR.getName() });

    public Hauptansicht() {
        super("Enigma");

        messageField.setLineWrap(true);
        messageField.setWrapStyleWord(true);

        keyField.setLineWrap(true);
        keyField.setWrapStyleWord(true);

        codedField.setLineWrap(true);
        codedField.setWrapStyleWord(true);

        /* Input */
        JPanel eingabePanel = new JPanel();
        eingabePanel.setLayout(new GridLayout(2, 2));
        JLabel messageLabel = new JLabel("Message");
        eingabePanel.add(messageLabel);
        eingabePanel.add(messageField);

        /* Key */
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new GridLayout(2, 2));
        JLabel keyLabel = new JLabel("Key");
        keyPanel.add(keyLabel);
        keyPanel.add(keyField);

        /* Encode */
        JPanel encodePanel = new JPanel();
        encodePanel.setLayout(new GridLayout(2, 2));
        JLabel encodeLabel = new JLabel("Encoded Message");
        encodePanel.add(encodeLabel);
        encodePanel.add(codedField);

        /* Buttons and Combo */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        crypterList.setSelectedIndex(0);
        buttonPanel.add(crypterList);

        JButton encodeButton = new JButton("Encode");
        buttonPanel.add(encodeButton);

        final JButton decodeButton = new JButton("Decode");
        buttonPanel.add(decodeButton);

        final JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);

        /* Center */
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(keyPanel, BorderLayout.NORTH);
        centerPanel.add(encodePanel, BorderLayout.CENTER);

        /* Master */
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BorderLayout());
        masterPanel.add(eingabePanel, BorderLayout.NORTH);
        masterPanel.add(centerPanel, BorderLayout.CENTER);
        masterPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(masterPanel);

        /* ActionListener for each encode/decode method */
        encodeButton.addActionListener(new EncoderActionListener(messageField,
                keyField, codedField, crypterList));

        decodeButton.addActionListener(new DecoderActionListener(messageField,
                keyField, codedField, crypterList));

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
