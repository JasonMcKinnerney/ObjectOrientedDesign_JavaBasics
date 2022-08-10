package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class UserSearchView extends JFrame {
    private JFrame Frame = new JFrame("User Search Window");
    private JPanel Panel = new JPanel();
    private JButton searchUserButton = new JButton("Search");
    private JLabel textLabel = new JLabel("Enter User Name:");
    private JButton menuButton = new JButton("Main Menu");
    private JTextField TextField = new JTextField();
    protected Library library;

    //"User Search Window"
    //  TextLabel
    //  TextField
    //  Menu Button
    //  Search Button

    UserSearchView(Library library){
        this.library = library;

        Frame.setSize(400, 200);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel.setLayout(new GridLayout(2, 2));

        //Main Menu Button
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == menuButton) {
                    Frame.dispose();
                    LibraryView libraryview = new LibraryView(library);
                }
            }
        });

        //  Search Button
        searchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = TextField.getText().toString();
                for (User user : library.users) {
                    if (txt.equals(user.getName()) && e.getSource() == searchUserButton) {
                        Frame.dispose();
                        UserOverView userView = new UserOverView(library, user);
                    }
                }
            }
        });

        Panel.add(textLabel);
        Panel.add(TextField);
        Panel.add(menuButton);
        Panel.add(searchUserButton);
        Frame.add(Panel);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }
}