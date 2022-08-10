import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Chatter extends JFrame implements IReceive {
  JLabel label = new JLabel();
  JTextField textfield = new JTextField();
  JButton button = new JButton( "Send" );
  ArrayList<String> Lines = new ArrayList<>(Arrays.asList(" ","","","","","","","",""," "));
  String _name;
  ISend _server;
  
  
    private String ConvoText() {
        String s = "<html>";
        for (int i = 0; i < 9; i++) s += Lines.get(i) + "<br>";
        return s+Lines.get(9)+"</html>";
    }

    public void Receive(String From, String Message) {
        Lines.remove(0);
        Lines.add(From + ": " + Message);
        label.setText(ConvoText());
    }

    public Chatter(String name, ISend server) {
        super();
        _name = name;
        _server = server;
        setTitle(_name);
        label.setText(ConvoText());
        textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(label); add(textfield); add(button);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _server.Send(_name, textfield.getText());
                textfield.setText("");
            }
        });
    
    }
}
