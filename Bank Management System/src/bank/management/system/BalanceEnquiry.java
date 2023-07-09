package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pin;
    
    BalanceEnquiry(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int bal = 0;
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            JLabel text = new JLabel("Your Account Balance is: Rs " + bal);
            text.setForeground(Color.WHITE);
            text.setBounds(170,300,400,30);
            image.add(text);
        } catch (Exception e) {
            System.out.print(e);
        }
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
    
    public static void main(String arg[]) {
        new BalanceEnquiry("");
    }
}
