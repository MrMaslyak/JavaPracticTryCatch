package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryCatchP extends JFrame implements ActionListener {
    JTextField textField;
    JButton button;
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
        textField.addActionListener(this);
        add(textField);

        button = new JButton("Click");
        button.setBounds(50, 100, 75, 30);
        button.addActionListener(this);
        add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try{
                textField.setText("");

            }catch (){

            }
        }
    }
}
