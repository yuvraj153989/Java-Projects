package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton one,five,ths,twoths,fths,tenths,bk;
    String pin;
    FastCash(String pin) {
        
        this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Georgia", Font.BOLD, 16));
        image.add(text);

        one = new JButton("Rs 100");
        one.setBounds(170, 415, 150, 30);
        one.addActionListener(this);
        image.add(one);

        five = new JButton("Rs 500");
        five.setBounds(355, 415, 150, 30);
        five.addActionListener(this);
        image.add(five);

        ths = new JButton("Rs 1000");
        ths.setBounds(170, 450, 150, 30);
        ths.addActionListener(this);
        image.add(ths);

        twoths = new JButton("Rs 2000");
        twoths.setBounds(355, 450, 150, 30);
        twoths.addActionListener(this);
        image.add(twoths);

        fths = new JButton("Rs 5000");
        fths.setBounds(170, 485, 150, 30);
        fths.addActionListener(this);
        image.add(fths);

        tenths = new JButton("Rs 10000");
        tenths.setBounds(355, 485, 150, 30);
        tenths.addActionListener(this);
        image.add(tenths);


        bk = new JButton("BACK");
        bk.setBounds(355, 520, 150, 30);
        bk.addActionListener(this);
        image.add(bk);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
    if (ae.getSource() == bk) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    } else {
        String amount = ((JButton) ae.getSource()).getText().substring(3);
        Conn c = new Conn();
        try {
            int bal = 0;
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (bal < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            Date date = new Date();
            String query = "INSERT INTO bank VALUES ('" + pin + "','" + date + "','Withdrawal','" + amount + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited!!");
            
            setVisible(false);
            new Transaction(pin).setVisible(true);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    }


    public static void main(String arg[]) {
        new FastCash("");
    }
}
