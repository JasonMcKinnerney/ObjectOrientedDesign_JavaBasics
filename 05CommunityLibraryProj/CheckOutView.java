package main;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOutView extends JFrame {
    private JFrame Frame = new JFrame("Checkout Item Window");
    private JPanel Panel = new JPanel();
    private JLabel label = new JLabel("Item List");
    private JButton requestButton = new JButton("Request");
    private JButton mainMenuButton = new JButton("Main Menu");
    protected Library library;
    protected User user;

    //"Checkout Item Window"
    //  MainMenu Button

    CheckOutView(Library library, User user){
        this.library = library;
        this.user = user;
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> itemList = new JList<>(model);

        for (Item item : library.items) {
            model.addElement(item.getName());
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(itemList);

        Frame.setSize(400, 250);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO:Request Button
        requestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == requestButton) {
                    String txt = itemList.getSelectedValue();
                    for(Item item : library.items) {
                        if(txt.equals(item.getName())) {
                            JOptionPane.showMessageDialog(null, user.requestItem(item));
                            Frame.dispose();
                            UserView userview = new UserView(library, user);
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
        Panel.add(requestButton);
        Panel.add(mainMenuButton);
        Frame.add(Panel);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }

}