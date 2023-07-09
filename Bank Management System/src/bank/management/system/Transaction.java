package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, wd, fc, ms, pc, bal, com, ex;
    String pin;
    Transaction(String pin) {
        
        this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction..");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Georgia", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        wd = new JButton("WITHDRAW");
        wd.setBounds(355, 415, 150, 30);
        wd.addActionListener(this);
        image.add(wd);

        fc = new JButton("FAST CASH");
        fc.setBounds(170, 450, 150, 30);
        fc.addActionListener(this);
        image.add(fc);

        ms = new JButton("MINI STATEMENT");
        ms.setBounds(355, 450, 150, 30);
        ms.addActionListener(this);
        image.add(ms);

        pc = new JButton("PIN CHANGE");
        pc.setBounds(170, 485, 150, 30);
        pc.addActionListener(this);
        image.add(pc);

        bal = new JButton("BALANCE");
        bal.setBounds(355, 485, 150, 30);
        bal.addActionListener(this);
        image.add(bal);

        com = new JButton("COMPLAINT*");
        com.setBounds(170, 520, 150, 30);
        com.addActionListener(this);
        image.add(com);

        ex = new JButton("EXIT");
        ex.setBounds(355, 520, 150, 30);
        ex.addActionListener(this);
        image.add(ex);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ex) {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)    //agar deposit pe click krega to ye wala display bandd hoga
        {
            setVisible(false);       //display off
            new Deposit(pin).setVisible(true);       //deposit class ke paas pin jaayega, and vo wala display open ho jyga
        }
        else if(ae.getSource()==wd)
        {
            setVisible(false);     //withdraw pe click krne se ye display close hoga
            new Withdrawal(pin).setVisible(true);     //withdrawal class khulega
        }
        else if(ae.getSource()==fc)       //fash cash pe click krne se..
        {
            setVisible(false);
            new FastCash(pin).setVisible(true);  
        }
        else if (ae.getSource() == pc) 
        {
            setVisible(false);
            new PINChange(pin).setVisible(true);
        }
        else if(ae.getSource()==bal)
        {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(ae.getSource()==ms)
        {
//            setVisible(false); not considering this line taaki transaction page ke sath hi display ho jaaye
            new MiniStatement(pin).setVisible(true);
        }
        else if(ae.getSource()==com)
        {
            setVisible(false);
            new Complaint(pin).setVisible(true);
        }
    }

    public static void main(String arg[]) {
        new Transaction("");
    }
}
