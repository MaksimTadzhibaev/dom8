package ru.MaksimTadzhibaev.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JTextField textField;
    private double total;
    private boolean isFirstDigit;
    private char operation;

    public Frame() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(350, 350, 200, 220);
        JPanel jPanel = new JPanel();
        textField = new JTextField(17);
        jPanel.add(textField);
        JButton[] jbs = new JButton[10];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton(String.valueOf(i));
            jPanel.add(jbs[i]);
            jbs[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    action(actionEvent);
                }
            });
        }
        JButton buttonDot = new JButton(".");
        jPanel.add(buttonDot);
        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == buttonDot) {
                    for (char c : textField.getText().toCharArray())
                        if (c == '.') {
                            textField.setText("Недопустимо");
                        } else {
                            textField.getText();
                        }
                }
                action(actionEvent);
            }
        });
        JButton buttonPlus = new JButton("+");
        jPanel.add(buttonPlus);
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == buttonPlus) {
                    for (char c : textField.getText().toCharArray())
                        if (c == '-' || c == '+' || c == '*' || c == '/') {
                            textField.setText("Недопустимо");
                        } else {
                            textField.getText();
                        }
                }
                action(actionEvent);
            }
        });
        JButton buttonMinus = new JButton("-");
        jPanel.add(buttonMinus);
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == buttonMinus) {
                    for (char c : textField.getText().toCharArray())
                        if (c == '-' || c == '+' || c == '*' || c == '/') {
                            textField.setText("Недопустимо");
                        } else {
                            textField.getText();
                        }
                }
                action(actionEvent);
            }
        });
        JButton buttonMultiply = new JButton("*");
        jPanel.add(buttonMultiply);
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == buttonMultiply) {
                    for (char c : textField.getText().toCharArray())
                        if (c == '-' || c == '+' || c == '*' || c == '/') {
                            textField.setText("Недопустимо");
                        } else {
                            textField.getText();
                        }
                }
                action(actionEvent);
            }
        });
        JButton buttonDivision = new JButton("/");
        jPanel.add(buttonDivision);
        buttonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == buttonDivision) {
                    for (char c : textField.getText().toCharArray())
                        if (c == '-' || c == '+' || c == '*' || c == '/') {
                            textField.setText("Недопустимо");
                        } else {
                            textField.getText();
                        }
                }
                action(actionEvent);
            }
        });
        JButton buttonEquals = new JButton("=");
        jPanel.add(buttonEquals);
        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calc(actionEvent);
            }
        });
        JButton buttonDel = new JButton("     CE      ");
        jPanel.add(buttonDel);
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == buttonDel) {
                    textField.setText(null);
                }
            }
        });
        JButton buttonDegree = new JButton("     X2     ");
        jPanel.add(buttonDegree);
        buttonDegree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == buttonDegree) {
                    String text = textField.getText();
                    double currentValue = Double.parseDouble(text);
                    total += currentValue;
                    total = total * total;
                    textField.setText(String.valueOf(total));
                    total = 0;
                }
            }
        });
        add(jPanel);
        setVisible(true);
        setResizable(false);
        textField.setEditable(false);
    }

    public void calc(ActionEvent actionEvent) {
        isFirstDigit = true;
        total = 0;
        String text = textField.getText();
        String digit = "";
        for (char c : text.toCharArray()) {
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                double currentValue = Double.parseDouble(digit);
                if (isFirstDigit) {
                    total += currentValue;
                    isFirstDigit = false;
                } else {
                    if (operation == '-') {
                        total -= currentValue;
                    } else if (operation == '+') {
                        total += currentValue;
                    } else if (operation == '*') {
                        total *= currentValue;
                    } else if (operation == '/') {
                        total /= currentValue;
                    }
                }

                digit = "";
                operation = c;
                continue;
            }

            digit += c;
        }
        double currentValue = Double.parseDouble(digit);
        if (operation == '-') {
            total -= currentValue;
        } else if (operation == '+') {
            total += currentValue;
        } else if (operation == '*') {
            total *= currentValue;
        } else if (operation == '/') {
            total /= currentValue;
        }

        isFirstDigit = true;
        textField.setText(String.valueOf(total));
        total = 0;
    }

    public void action(ActionEvent event) {
        textField.setText(textField.getText() + event.getActionCommand());
    }
}