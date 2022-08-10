package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenewItemView extends JFrame {
    private JFrame Frame = new JFrame("Renew Item Window");
    private JPanel Panel = new JPanel();
    private JLabel label = new JLabel("Item List");
    private JButton renewItemButton = new JButton("Renew Item");
    private JButton mainMenuButton = new JButton("Main Menu");
    protected Library library;
    protected User user;

    //"RenewItemView"
    //  ItemName TextField
    //  User specific Items Checkout List
    //  Renew Item Button
    //  MainMenu Button

    RenewItemView(Library library, User user){
        this.library = library;
        this.user = user;

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> usersItemList = new JList<>(model);

        for (String string : user.getItemsCheckedOut()) {
            model.addElement(string);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(usersItemList);

        Frame.setSize(400, 250);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO:RenewItem Button
        renewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == renewItemButton) {
                    String txt = usersItemList.getSelectedValue();
                    for(Item item : library.items) {
                        if(txt.equals(item.getName())) {
                            JOptionPane.showMessageDialog(null, user.renewItem(item));
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
        Panel.add(renewItemButton);
        Panel.add(mainMenuButton);
        Frame.add(Panel);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }

}