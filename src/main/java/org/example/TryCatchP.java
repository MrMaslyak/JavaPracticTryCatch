package org.example;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;


public class TryCatchP extends JFrame implements ActionListener {
    private JTextField textField, textFieldForEmail;
    private JButton button, arrayCheck, validEmail;
    private JLabel label = null, labelForList = null, labelForEmail = null;
    private List<Integer> numbers = new ArrayList<>();
    private int maxSize = 5;

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
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new LengthFilter(5));
        add(textField);

        button = new JButton("Send");
        button.setBounds(50, 100, 75, 30);
        button.addActionListener(this);
        add(button);

        arrayCheck = new JButton("AddNumberInArray");
        arrayCheck.setBounds(50, 150, 200, 30);
        arrayCheck.addActionListener(this);
        add(arrayCheck);
        List<Integer> numbers = new ArrayList<>();

        textFieldForEmail  = new JTextField();
        textFieldForEmail.setBounds(50, 200, 200, 30);
        textFieldForEmail.addActionListener(this);
        add(textFieldForEmail);

        validEmail = new JButton("Validate Email");
        validEmail.setBounds(50, 250, 200, 30);
        validEmail.addActionListener(this);
        add(validEmail);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                if (label != null) {
                    remove(label);
                }
                String text = textField.getText();
                if (text.trim().isEmpty()) {
                    throw new NullPointerException();
                }
                int number = Integer.parseInt(text);
                label = new JLabel("Your ID: " + text);
                textField.setText("");
                label.setBounds(130, 100, 200, 40);
                add(label);
                revalidate();
                repaint();
            } catch (NumberFormatException ex) {
                if (label != null) {
                    remove(label);
                }

                label = new JLabel("You mustn't have letters");
                label.setBounds(130, 100, 200, 40);
                add(label);
                revalidate();
                repaint();
            } catch (NullPointerException ept) {
                if (label != null) {
                    remove(label);
                }
                label = new JLabel("You must enter something");
                label.setBounds(130, 100, 200, 40);
                add(label);
                revalidate();
                repaint();
            }
        }

        if (e.getSource() == arrayCheck) {
            try {
                if (numbers.size() < maxSize) {
                    if (labelForList != null) {
                        remove(labelForList);
                    }
                    numbers.add(numbers.size() + 1);
                    labelForList = new JLabel("Added element. Current list: " + numbers);
                    labelForList.setBounds(256, 150, 300, 40);
                    add(labelForList);
                    revalidate();
                    repaint();
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException ex) {
                if (labelForList != null) {
                    remove(labelForList);
                }
               labelForList  = new JLabel("Error: Maximum size of the list reached.");
                labelForList.setBounds(256, 150, 300, 40);
                add(labelForList);
                revalidate();
                repaint();
            }
        }
        if ( e.getSource() == validEmail) {
            try{
                if (labelForEmail != null) {
                    remove(labelForEmail);
                }
                String email = textFieldForEmail.getText();
                 if (email.contains("@")) {
                     labelForEmail = new JLabel("Email is valid.");
                     labelForEmail.setBounds(256, 200, 300, 40);
                     add(labelForEmail);
                 } else {
                     throw new IllegalArgumentException();
                 }

            }catch (IllegalArgumentException ex){
                if (labelForEmail != null) {
                    remove(labelForEmail);
                }
                labelForEmail = new JLabel("Email is not valid.");
                labelForEmail.setBounds(256, 200, 300, 40);
                add(labelForEmail);
            }finally {
                revalidate();
                repaint();
            }
        }

    }
}
