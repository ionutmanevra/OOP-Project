package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminMenu extends JFrame {
    private JPanel contentPane;
    private JButton addPacketButton;
    private JButton removePacketButton;
    private JButton logoutButton;

    public AdminMenu() {
        setTitle("Admin Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        addPacketButton = new JButton("Add Packet");
        removePacketButton = new JButton("Remove Packet");
        logoutButton = new JButton("Logout");

        contentPane.setLayout(new GridLayout(3, 1));
        contentPane.add(addPacketButton);
        contentPane.add(removePacketButton);
        contentPane.add(logoutButton);

        setContentPane(contentPane);

        addPacketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAddPacket();
            }
        });

        removePacketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRemovePacket();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogout();
            }
        });

        setVisible(true);
    }

    private void onAddPacket() {

    }

    private void onRemovePacket() {

    }

    private void onLogout() {
        dispose();
        new LoginSelection();
    }

    public static void main(String[] args) {
        new AdminMenu();
    }
}