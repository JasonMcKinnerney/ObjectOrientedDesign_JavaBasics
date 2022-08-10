package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserView extends JFrame {
    private JFrame userFrame = new JFrame("New User");
    private JPanel userPanel = new JPanel();
    private JLabel nameLabel = new JLabel("Name: ");
    private JTextField nameField = new JTextField(10);
    private JLabel addressLabel = new JLabel("Address: ");
    private JTextField addressField = new JTextField(10);
    private JLabel ageLabel = new JLabel("Age: ");
    private JTextField ageField = new JTextField(10);
    private JLabel phoneNumberLabel = new JLabel("Phone #: ");
    private JTextField phoneNumberField = new JTextField(10);
    private JButton menuButton = new JButton("Main Menu");
    private JButton addButton = new JButton("Add User");
    protected Library library;
    protected User user;

    //  "New User"
    //  Name:
    //  Address:
    //  Age:
    //  Phone #:
    //  Menu Button
    //  AddUser Button

    AddUserView(Library library) {
        this.library = library;

        userFrame.setSize(450, 550);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userPanel.setLayout(new GridLayout(5, 2));

        //Main Menu Button
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == menuButton) {
                    userFrame.dispose();
                    LibraryView libraryview = new LibraryView(library);
                }
            }
        });

        //Add User Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Text Field
                String name = nameField.getText();
                String address = addressField.getText();
                String age = ageField.getText();
                String phoneNumber = phoneNumberField.getText();
                if (e.getSource() == addButton) {
                    User tempUser = new User(name, address, phoneNumber, Integer.parseInt(age));
                    library.addUser(tempUser);
                    userFrame.dispose();
                    LibraryView libraryview = new LibraryView(library);
                }
            }
        });

        userPanel.add(nameLabel);
        userPanel.add(nameField);
        userPanel.add(addressLabel);
        userPanel.add(addressField);
        userPanel.add(ageLabel);
        userPanel.add(ageField);
        userPanel.add(phoneNumberLabel);
        userPanel.add(phoneNumberField);
        userPanel.add(menuButton);
        userPanel.add(addButton);
        userFrame.add(userPanel);
        userFrame.setLocationRelativeTo(null);
        userFrame.setVisible(true);
    }
}