package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ItemSearchView extends JFrame {
    private JFrame Frame = new JFrame("Item Search Window");
    private JPanel Panel = new JPanel();
    private JButton searchButton = new JButton("Search");
    private JTextField TextField = new JTextField();
    private JLabel textLabel = new JLabel("Enter Item Name:");
    private JLabel chooseLabel = new JLabel("Or choose Item Type");
    private JButton typeButton = new JButton("See list");
    private String[] typeStrings = { "Books" , "Ref-Books", "Magazines", "AudVid" };
    private JComboBox itemType = new JComboBox(typeStrings);
    private JButton menuButton = new JButton("Main Menu");
    protected Library library;

    //"Item Search Window"
    //  TextLabel
    //  TextField
    //  Menu Button
    //  Search Button

    ItemSearchView(Library library){

        this.library = library;
        Frame.setSize(500, 200);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel.setLayout(new GridLayout(2, 4));
        Panel.add(textLabel);
        Panel.add(TextField);
        Panel.add(searchButton);
        Panel.add(menuButton);
        Panel.add(chooseLabel);
        Panel.add(itemType);
        Panel.add(typeButton);
        Frame.add(Panel);

        //  Main Menu Button
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
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = TextField.getText().toString();
                for (Item item : library.items) {
                    if (txt.equals(item.getName()) && e.getSource() == searchButton) {
                        Frame.dispose();
                        ItemView itemView = new ItemView(library, item);
                    }
                }
            }
        });

        //  List Type Button
        typeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) itemType.getSelectedItem();
                Frame.dispose();
                ItemCatView itemCatView = new ItemCatView(library, selected);
            }

        });


        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }
}