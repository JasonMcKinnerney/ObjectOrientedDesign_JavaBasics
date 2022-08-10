package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserOverView {




    private JPanel userPanel = new JPanel();
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel ageLabel = new JLabel("Age:");
    private JLabel addressLabel = new JLabel("Address: ");
    private JLabel phoneLabel = new JLabel("Phone Number: ");
    private JLabel libraryIdLabel = new JLabel("Library Card Number: ");
    private JLabel numitemsCheckedOut = new JLabel("# Items Checked Out");
    private JLabel checkedOutItemsLabel = new JLabel("Checked Out:");
    private JLabel finesLabel = new JLabel("Total Fines: ");


    private JButton LoginButton = new JButton("User Login");
    private JButton mainMenuButton = new JButton("Main Menu");
    protected Library library;
    protected User user;


    UserOverView(Library library, User user) {
        this.library = library;
        this.user = user;

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> usersItemList = new JList<>(model);

        for (String string : user.getItemsCheckedOut()) {
        	String dueDate = "";
        	for (Item item : library.items) {
        		if (string.equals(item.getName())) {
        			dueDate = item.loan.getDueDate();
        		}
        	}
        	String totString = (string + " Due Date: " + dueDate);
            model.addElement(totString);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(usersItemList);

        JLabel name = new JLabel(user.getName());
        JFrame userFrame = new JFrame(user.getName() + "'s Library Card");
        JLabel age = new JLabel(Integer.toString(user.getAge()));
        JLabel address = new JLabel(user.getAddress());
        JLabel phone = new JLabel(user.getPhoneNumber());
        JLabel libraryId = new JLabel(Integer.toString(user.getID()));
        String currentFines = Double.toString(user.getFines());
        JLabel fines = new JLabel(currentFines);
        JLabel chkOut = new JLabel(Integer.toString(user.getNumItemsChecked()));

        userFrame.setSize(450, 550);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userPanel.setLayout(new GridLayout(12,2));


        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == LoginButton) {
                    userFrame.dispose();
                    UserLoginView userLoginView = new UserLoginView(library, user);
                }
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mainMenuButton) {
                    userFrame.dispose();
                    LibraryView libraryview = new LibraryView(library);
                }
            }
        });

        userPanel.add(nameLabel);
        userPanel.add(name);
        userPanel.add(ageLabel);
        userPanel.add(age);
        userPanel.add(addressLabel);
        userPanel.add(address);
        userPanel.add(phoneLabel);
        userPanel.add(phone);
        userPanel.add(libraryIdLabel);
        userPanel.add(libraryId);
        userPanel.add(finesLabel);
        userPanel.add(fines);
        userPanel.add(numitemsCheckedOut);
        userPanel.add(chkOut);
        userPanel.add(checkedOutItemsLabel);
        userPanel.add(scrollPane);
        userPanel.add(LoginButton);
        userPanel.add(mainMenuButton);
        userFrame.add(userPanel);
        userFrame.setLocationRelativeTo(null);
        userFrame.setVisible(true);
    }

}