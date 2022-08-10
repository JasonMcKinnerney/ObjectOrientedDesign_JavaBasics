package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemView extends JFrame {
    private JFrame userFrame = new JFrame("New Item");
    private JPanel userPanel = new JPanel();
    private JLabel nameLabel = new JLabel("Name: ");
    private JTextField nameField = new JTextField(10);
    private JLabel valueLabel = new JLabel("Value: ");
    private JTextField valueField = new JTextField(10);
    private JLabel itemTxt = new JLabel("Type: ");
    private String[] typeStrings = { "Books" , "Ref-Books", "Magazines", "AudVid" };
    private JComboBox itemType = new JComboBox(typeStrings);
    private JButton addButton = new JButton("Add Item");
    private JButton menuButton = new JButton("Main Menu");
    private JLabel bestTxt = new JLabel("Best Seller");
    private String[] bestStrings = { "No", "Yes" };
    private JComboBox bestType = new JComboBox(bestStrings);
    protected Library library;



    AddItemView(Library library) {
        this.library = library;

        userFrame.setSize(450, 550);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userPanel.setLayout(new GridLayout(8, 1));

        //Text Field


        //Add Item Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String temp = valueField.getText();
                Float value = Float.parseFloat(temp);
                if (e.getSource() == addButton) {
                    String x = (String) itemType.getSelectedItem();
                    String y = (String) bestType.getSelectedItem();
                    if (x.equals("Books")) {
                        if (y.equals("Yes")) {
                            Book z = new Book(name, value, true);
                            library.books.add(z);
                            library.items.add(z);
                        }
                        else {
                            Book z = new Book(name, value, false);
                            library.books.add(z);
                            library.items.add(z);
                        }
                    }
                    else if (x.equals("AudVid")) {
                        AudVid z = new AudVid(name, value);
                        library.audvids.add(z);
                        library.items.add(z);
                    }
                    else if (x.equals("Ref-Books")) {
                        ReferenceBook z = new ReferenceBook(name, value);
                        library.refbooks.add(z);
                        library.items.add(z);
                    }
                    else {
                        Magazine z = new Magazine(name,value);
                        library.mags.add(z);
                        library.items.add(z);
                    }

                    userFrame.dispose();
                    LibraryView libraryview = new LibraryView(library);
                }
            }});

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


        userPanel.add(nameLabel);
        userPanel.add(nameField);
        userPanel.add(valueLabel);
        userPanel.add(valueField);
        userPanel.add(itemTxt);
        userPanel.add(itemType);
        userPanel.add(bestTxt);
        userPanel.add(bestType);
        userPanel.add(menuButton);
        userPanel.add(addButton);
        userFrame.add(userPanel);
        userFrame.setLocationRelativeTo(null);
        userFrame.setVisible(true);
    }
}
