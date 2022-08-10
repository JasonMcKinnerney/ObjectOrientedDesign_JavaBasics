package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class AllUserView {


    private JFrame Frame = new JFrame("Library Members Window");
    private JPanel Panel = new JPanel();
    private JLabel label = new JLabel("User List");
    private JButton viewSelectButton = new JButton("View User");
    private JButton mainMenuButton = new JButton("Main Menu");
    protected Library library;
    protected String type;



    AllUserView(Library library){
        this.library = library;
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> userList = new JList<>(model);

        for (User user : library.users) {
            model.addElement(user.getName());
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(userList);

        Frame.setSize(400, 200);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel.setLayout(new GridLayout(1, 4));

        viewSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == viewSelectButton) {
                    String txt = userList.getSelectedValue();
                    for (User user : library.users) {
                        if (txt.equals(user.getName())) {
                            Frame.dispose();
                            UserOverView userOverview = new UserOverView(library, user);
                        }
                    }
                }
            }
        });

        //MainMenu Button
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mainMenuButton) {
                    Frame.dispose();
                    LibraryView libraryview = new LibraryView(library);
                }
            }
        });

        Panel.add(label);
        Panel.add(scrollPane);
        Panel.add(viewSelectButton);
        Panel.add(mainMenuButton);
        Frame.add(Panel);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }
}