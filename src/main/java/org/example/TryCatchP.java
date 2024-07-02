package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class TryCatchP extends JFrame implements ActionListener {
    JTextField textField;
    JButton button, arrayCheck;
    JLabel label;
    int y = 200;
    List<Integer> numbers = new ArrayList<>();
    List<Integer> limitedNumber;
    int  maxSize = 5;
    TryCatchP() {
        setSize(500, 500);
        setTitle("Try Catch Practice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ui();
        setVisible(true);

    }

    public void ui() {
        textField = new JTextField();
        textField.setBounds(50, 50, 200, 30);
        textField.addActionListener(this);
        add(textField);

        button = new JButton("Click");
        button.setBounds(50, 100, 75, 30);
        button.addActionListener(this);
        add(button);

        arrayCheck = new JButton("AddNumberInArray");
        arrayCheck.setBounds(50, 150, 200, 30);
        arrayCheck.addActionListener(this);
        add(arrayCheck);
        List<Integer> numbers = new ArrayList<>();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                String text = textField.getText();
                int number = Integer.parseInt(text);
                label = new JLabel("Your ID: " + textField.getText());
                textField.setText("");
                label.setBounds(50, y, 200, 40);
                y += 40;
                add(label);
                revalidate();
                repaint();
            } catch (NumberFormatException ex) {
                System.out.println("You mustn`t have a litters");
            }
        }
        if (e.getSource() == arrayCheck) {
            try {
                if (numbers.size() < maxSize) {
                    numbers.add(numbers.size() + 1);
                    System.out.println("Добавлен элемент. Текущий список: " + numbers);
                }else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Limit size in list: 5");
            }
        }
    }
}
