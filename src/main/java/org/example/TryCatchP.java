package org.example;

import javax.swing.*;

public class TryCatchP extends JFrame {
    JTextField textField;
    TryCatchP () {
        setSize(500, 500);
        setTitle("Try Catch Practice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ui();
        setVisible(true);

    }

    public void ui () {
        textField = new JTextField();
        textField.setBounds(50, 50, 200, 30);

        add(textField);

        JButton button = new JButton("Click");
        button.setBounds(50, 100, 100, 30);
        add(button);

    }
}
