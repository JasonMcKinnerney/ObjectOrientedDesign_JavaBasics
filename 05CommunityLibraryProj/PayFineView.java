package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayFineView extends JFrame {
    private JFrame Frame = new JFrame("Pay Fine Window");
    private JPanel Panel = new JPanel();
    private JLabel label = new JLabel("Total Fines: ");
    private JLabel fineLabel = new JLabel("Enter $ Amount: ");
    private JTextField TextField = new JTextField();
    private JButton payFineButton = new JButton("Pay Fine");
    private JButton mainMenuButton = new JButton("Main Menu");
    protected Library library;
    protected User user;
    

    //"Pay Fine Window"
    //  Total Fines:
    //  fineAmount TextField
    //  PayFine Button
    //  MainMenu Button

    PayFineView(Library library, User user){
        this.library = library;
        this.user = user;

        Frame.setSize(400, 250);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel.setLayout(new GridLayout(3, 2));
        
        String currentFines = Double.toString(user.getFines());
        JLabel fines = new JLabel(currentFines);

        //PayFine Button
        payFineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == payFineButton) {
                    String text = TextField.getText();
                    double fine = Double.parseDouble(text);
                    user.payFines(fine);
                    Frame.dispose();
                    UserView userview = new UserView(library, user);
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
        Panel.add(fines);
        Panel.add(fineLabel);
        Panel.add(TextField);
        Panel.add(payFineButton);
        Panel.add(mainMenuButton);
        Frame.add(Panel);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }

}