package de.wagnst.tpe.exercise.swingOberflaeche;

import de.wagnst.tpe.exercise.crypter.CrypterVerfahren;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enigma extends JFrame {

    private JPanel contentPane;
    private JTextField keyField;

    /**
     * Create the frame.
     */
    public Enigma() {
        setResizable(false);
        setTitle("Enigma");
        setFont(new Font("Bell MT", Font.PLAIN, 12));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
        contentPane.setBorder(null);
        setContentPane(contentPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(211, 211, 211));
        buttonPanel.setForeground(Color.WHITE);
        buttonPanel.setAutoscrolls(true);
        buttonPanel.setBorder(new LineBorder(new Color(128, 128, 128)));

        JPanel keyPanel = new JPanel();
        keyPanel.setForeground(new Color(255, 255, 255));
        keyPanel.setBackground(new Color(204, 204, 204));
        keyPanel.setBorder(new LineBorder(new Color(128, 128, 128)));

        keyField = new JTextField();
        keyField.setFont(new Font("Arial", Font.PLAIN, 10));
        keyField.setColumns(10);

        JLabel keyLabel = new JLabel("Key");
        keyLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        GroupLayout gl_keyPanel = new GroupLayout(keyPanel);
        gl_keyPanel.setHorizontalGroup(
                gl_keyPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_keyPanel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(keyLabel)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(keyField, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );
        gl_keyPanel.setVerticalGroup(
                gl_keyPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_keyPanel.createSequentialGroup()
                                .addGap(5)
                                .addGroup(gl_keyPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(keyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(keyLabel))
                                .addGap(2))
        );
        keyPanel.setLayout(gl_keyPanel);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JComboBox comboBox = new JComboBox(new String[]{
                CrypterVerfahren.SUBSTITUTION.getName(),
                CrypterVerfahren.CAESAR.getName(),
                CrypterVerfahren.XOR.getName(),
                CrypterVerfahren.NEW_CIPHER.getName()});
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setBackground(SystemColor.window);

        comboBox.setSelectedIndex(0);

        comboBox.setFont(new Font("Arial", Font.PLAIN, 11));
        buttonPanel.add(comboBox);

        JButton encodeButton = new JButton("Encode");
        encodeButton.setForeground(SystemColor.menuText);
        encodeButton.setFont(new Font("Arial", Font.PLAIN, 11));
        buttonPanel.add(encodeButton);

        JButton decodeButton = new JButton("Decode");
        decodeButton.setForeground(SystemColor.menuText);
        decodeButton.setFont(new Font("Arial", Font.PLAIN, 11));
        buttonPanel.add(decodeButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setForeground(SystemColor.menuText);
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 11));
        buttonPanel.add(cancelButton);

        JPanel messagePanel = new JPanel();
        messagePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(176, 196, 222), new Color(176, 196, 222), new Color(176, 196, 222), new Color(176, 196, 222)));
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.X_AXIS));

        JScrollPane messageScrollPane = new JScrollPane();
        messageScrollPane.setViewportBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        messageScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        messagePanel.add(messageScrollPane);

        JTextArea messageArea = new JTextArea();
        messageArea.setFont(new Font("Arial", Font.PLAIN, 12));
        messageArea.setWrapStyleWord(true);
        messageArea.setLineWrap(true);
        messageScrollPane.setViewportView(messageArea);

        JLabel lblMessage = new JLabel("Message");
        lblMessage.setBackground(new Color(204, 204, 204));
        lblMessage.setFont(new Font("Arial", Font.ITALIC, 13));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageScrollPane.setColumnHeaderView(lblMessage);

        JPanel returnPanel = new JPanel();
        returnPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(176, 196, 222), new Color(176, 196, 222), new Color(176, 196, 222), new Color(176, 196, 222)));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(5)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(keyPanel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                                        .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(messagePanel, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(returnPanel, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                                .addGap(15))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(returnPanel, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                        .addComponent(messagePanel, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(keyPanel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addGap(3)
                                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(10))
        );
        returnPanel.setLayout(new BoxLayout(returnPanel, BoxLayout.X_AXIS));

        JScrollPane returnScrollPane = new JScrollPane();
        returnScrollPane.setViewportBorder(new LineBorder(new Color(192, 192, 192)));
        returnScrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        returnPanel.add(returnScrollPane);

        JTextArea returnArea = new JTextArea();
        returnArea.setFont(new Font("Arial", Font.PLAIN, 12));
        returnArea.setWrapStyleWord(true);
        returnArea.setLineWrap(true);
        returnArea.setEditable(false);
        returnScrollPane.setViewportView(returnArea);

        JLabel lblNewLabel = new JLabel("Return");
        lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 13));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        returnScrollPane.setColumnHeaderView(lblNewLabel);
        contentPane.setLayout(gl_contentPane);


        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        encodeButton.addActionListener(new EncoderActionListener(messageArea, keyField, returnArea, comboBox));
        decodeButton.addActionListener(new DecoderActionListener(messageArea, keyField, returnArea, comboBox));

    }

}
