package com.tourismagency.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame {
    private JTextField nameField;
    private JTextField emailField;

    public LoginWindow() {
        setTitle("Client Login");
        setSize(350, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        getContentPane().setBackground(Color.decode("#004D40"));

        nameField = new JTextField();
        emailField = new JTextField();

        JButton loginButton = new JButton("Login");
        styleButton(loginButton);
        loginButton.addActionListener(e -> login());

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Email:"));
        add(emailField);
        add(loginButton);
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#FF7043"));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#BF360C"), 2));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.decode("#D84315"));
                button.setFont(button.getFont().deriveFont(16f));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.decode("#FF7043"));
                button.setFont(button.getFont().deriveFont(14f));
            }
        });
    }

    private void login() {
        String name = nameField.getText();
        String email = emailField.getText();
        if (!name.isEmpty() && !email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            this.dispose();
            new TouristPackagesWindow().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both name and email.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}