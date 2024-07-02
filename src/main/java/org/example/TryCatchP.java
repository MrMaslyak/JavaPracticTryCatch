package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryCatchP extends JFrame implements ActionListener {
    JTextField textField;
    JButton button;
    JLabel label;
    boolean isFail = false;
    int y = 200;
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
                String text = textField.getText();
                int number = Integer.parseInt(text);
                label = new JLabel("You entered: " + textField.getText());
                textField.setText("");
                label.setBounds(50, y , 75, 40);
                y+=40;
                add(label);

            }catch (NumberFormatException ex){
                System.out.println("You mustn`t have a litters");
            }
        }
    }
}
