package de.wagnst.tpe.exercise.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hauptansicht extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextArea messageField = new JTextArea();
    private JTextArea keyField = new JTextArea("DEFGHIJKLMNOPQRSTUVWXYZABC");
    private JTextArea codedField = new JTextArea();

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

        /* Buttons */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton encodeButton = new JButton("encode");
        buttonPanel.add(encodeButton);
        JButton decodeButton = new JButton("decode");
        buttonPanel.add(decodeButton);
        JButton cancleButton = new JButton("cancle");
        buttonPanel.add(cancleButton);

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
        encodeButton.addActionListener(new SubstiEncoderActionListener(
                messageField, keyField, codedField));
        decodeButton.addActionListener(new SubstiDecoderActionListener(
                messageField, keyField, codedField));

        cancleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
