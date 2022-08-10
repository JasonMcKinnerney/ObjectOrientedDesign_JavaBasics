package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemCatView {


    private JFrame Frame = new JFrame("Category Window");
    private JPanel Panel = new JPanel();
    private JLabel label = new JLabel("Item List");
    private JButton viewSelectButton = new JButton("View Selection");
    private JButton mainMenuButton = new JButton("Main Menu");
    protected Library library;
    protected String type;



    ItemCatView(Library library, String x){
        this.library = library;
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> catList = new JList<>(model);
        if (x.equals("Books")){
            for (Book book : library.books) {
                model.addElement(book.getName());
            }
        }
        else if (x.equals("AudVid")) {
            for (AudVid av : library.audvids) {
                model.addElement(av.getName());
            }
        }
        else if (x.equals("Ref-Books")) {
            for (ReferenceBook refbook : library.refbooks) {
                model.addElement(refbook.getName());
            }
        }
        else {
            for (Magazine mag : library.mags) {
                model.addElement(mag.getName());
            }
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(catList);

        Frame.setSize(500, 200);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel.setLayout(new GridLayout(2, 2));

        viewSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == viewSelectButton) {
                    String txt = catList.getSelectedValue();
                    for (Item item : library.items) {
                        if (txt.equals(item.getName())) {
                            Frame.dispose();
                            ItemView itemView = new ItemView(library, item);
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
        Panel.add(mainMenuButton);
        Panel.add(viewSelectButton);
        Frame.add(Panel);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }

}