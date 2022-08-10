package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ItemView extends JFrame {
    private JFrame itemFrame = new JFrame("Item Description");
    private JPanel itemPanel = new JPanel();
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel valueLabel = new JLabel("Value: ");
    private JLabel loanabilityLabel = new JLabel("Able to loan: ");
    private JLabel availabilityLabel = new JLabel("Checked Out: ");
    private JLabel requestedLabel = new JLabel("Requested: ");
    private JLabel dueDateLabel = new JLabel("Date Due: ");
    private JButton menuButton = new JButton("Main Menu");
    protected Library library;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    //"Item Description"
    //  Name:
    //  Value:
    //  Able to loan:
    //  Availability:
    //  Requested:
    //  Date Due:
    //  Main Menu Button to return to LibraryView()

    ItemView(Library library, Item item) {

        boolean chkOut = !item.isAvailable();
        this.library = library;
        JLabel name = new JLabel(item.getName());
        JLabel value = new JLabel(Float.toString(item.valueOfItem));
        JLabel loanability = new JLabel(String.valueOf(item.isloanable()));
        JLabel checkedOut = new JLabel(String.valueOf(chkOut));
        JLabel requested = new JLabel(String.valueOf(item.isRequested()));
        JLabel dueDate = new JLabel();

        if(!item.isAvailable())
            dueDate = new JLabel(item.loan.getDueDate());

        itemFrame.setSize(450, 550);
        itemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        itemPanel.setLayout(new GridLayout(7, 1));

        //  Menu Button
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == menuButton) {
                    itemFrame.dispose();
                    LibraryView libraryview = new LibraryView(library);
                }
            }
        });

        itemPanel.add(nameLabel);
        itemPanel.add(name);
        itemPanel.add(valueLabel);
        itemPanel.add(value);
        itemPanel.add(loanabilityLabel);
        itemPanel.add(loanability);
        itemPanel.add(availabilityLabel);
        itemPanel.add(checkedOut);
        itemPanel.add(requestedLabel);
        itemPanel.add(requested);
        itemPanel.add(dueDateLabel);
        itemPanel.add(dueDate);
        itemPanel.add(new JLabel());
        itemPanel.add(menuButton);
        itemFrame.add(itemPanel);
        itemFrame.setLocationRelativeTo(null);
        itemFrame.setVisible(true);
    }
}