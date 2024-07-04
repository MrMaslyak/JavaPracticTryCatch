package org.example;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckValidData extends JFrame implements ActionListener {
    private JLabel name, age, result;
    private JTextField nameField, ageField, resultField;
    private JButton checkButtom;

    CheckValidData() {
        setSize(200, 200);
        setTitle("Check Valid Data");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ui();
        setVisible(true);
    }

    private void ui() {
        name = new JLabel("Name:");
        name.setBounds(10, 10, 50, 20);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(70, 10, 100, 20);
        add(nameField);

        age = new JLabel("Age:");
        age.setBounds(10, 40, 50, 20);
        add(age);

        ageField = new JTextField();
        ageField.setBounds(70, 40, 100, 20);
        add(ageField);

        checkButtom = new JButton("Check");
        checkButtom.setBounds(70, 70, 100, 20);
        checkButtom.addActionListener(this);
        add(checkButtom);

        result = new JLabel("Result:");
        result.setBounds(10, 100, 50, 20);
        add(result);

        resultField = new JTextField();
        resultField.setBounds(70, 100, 100, 20);
        resultField.setEditable(false);
        resultField.setFocusable(false);
        resultField.setOpaque(false);
        resultField.setFont(new Font("Arial", Font.ITALIC, 8));
        add(resultField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButtom) {
            String name = nameField.getText().trim();
            String age = ageField.getText().trim();
            if (name.isEmpty() && age.isEmpty()) {
                resultField.setText("Please enter name and age.");
                return;
            }
            if (name.isEmpty()) {
                resultField.setText("Please enter name.");
                return;
            }
            if (age.isEmpty()) {
                resultField.setText("Please enter age.");
                return;
            }
            try {
                int ageValue = Integer.parseInt(age);
                if (ageValue <= 0) {
                    throw new IllegalArgumentException();
                }
                if (ageValue > 100) {
                    throw new Exception();
                }

                resultField.setText("True");

            } catch (NumberFormatException ex) {
                resultField.setText("Age must be a number.");
            } catch (IllegalArgumentException ex) {
                resultField.setText("Age must be positive.");
            } catch (Exception ex) {
                resultField.setText("An error occurred.");
            } finally {
                nameField.setText("");
                ageField.setText("");
            }
        }
    }
}