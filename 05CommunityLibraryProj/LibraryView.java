package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryView extends JFrame {
    private JFrame homeFrame = new JFrame("Library System Window");
    private JPanel homePanel = new JPanel();
    private JButton UserInfoButton = new JButton("Lookup User Info");
    private JButton ItemInfoButton = new JButton("Lookup Item Info");
    private JButton AddUserButton = new JButton("Add User");
    private JButton AddItemButton = new JButton("Add Item");

    protected Library library;

    //"Library System Window"
    //  Lookup User Info Button
    //  Lookup Item Info Button
    //  Add User Button
    //  Add Item Button

    LibraryView(Library library) {
        this.library = library;

        homeFrame.setSize(450, 550);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homePanel.setLayout(new GridLayout(4, 1));

        UserInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == UserInfoButton) {
                    homeFrame.dispose();
                    AllUserView user = new AllUserView(library);
                }
            }
        });

        ItemInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ItemInfoButton) {
                    homeFrame.dispose();
                    ItemSearchView item = new ItemSearchView(library);
                }
            }
        });

        AddUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == AddUserButton) {
                    homeFrame.dispose();
                    AddUserView user = new AddUserView(library);
                }
            }
        });

        AddItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == AddItemButton) {
                    homeFrame.dispose();
                    AddItemView item = new AddItemView(library);
                }
            }
        });

        homePanel.add(UserInfoButton);
        homePanel.add(ItemInfoButton);
        homePanel.add(AddUserButton);
        homePanel.add(AddItemButton);
        homeFrame.add(homePanel);
        homeFrame.setLocationRelativeTo(null);
        homeFrame.setVisible(true);
    }
}