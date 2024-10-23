package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSelection extends JFrame {
    private JPanel contentPane;
    private JButton buttonAdmin;
    private JButton buttonClient;
    private final String ADMIN_PASSWORD = "admin123";

    public LoginSelection() {
        setTitle("Login Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        buttonAdmin = new JButton("Admin Login");
        buttonClient = new JButton("Client Login");

        contentPane.setLayout(new GridLayout(2, 1));
        contentPane.add(buttonClient);
        contentPane.add(buttonAdmin);

        setContentPane(contentPane);

        getRootPane().setDefaultButton(buttonAdmin);

        buttonAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdmin();
            }
        });

        buttonClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClient();
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setVisible(true);
    }

    private void onAdmin() {
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(this, passwordField, "Enter Admin Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String enteredPassword = new String(passwordField.getPassword());

            if (ADMIN_PASSWORD.equals(enteredPassword)) {
                dispose();
                System.out.println("Admin Login clicked");
                new AdminMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void onClient() {
        dispose();
        System.out.println("Client Login clicked");
        new ClientLogin();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        new LoginSelection();
    }
}