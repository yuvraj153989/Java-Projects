package bank.management.system;

import java.awt.Color;
import javax.swing.*;              //new class for Signup button, it will contain form like thing for creating new user..
import java.awt.*;          //for colors
import java.util.*;
import com.toedter.calendar.JDateChooser;   //for date year box
import java.awt.event.*;

public class Signup3 extends JFrame implements ActionListener {

    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JRadioButton r1, r2, r3, r4;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Reccuring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup accgrp = new ButtonGroup();
        accgrp.add(r1);
        accgrp.add(r2);
        accgrp.add(r3);
        accgrp.add(r4);

        JLabel card = new JLabel("Card Number: ");             //Card Number
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        JLabel number = new JLabel("XXXX-XXXX-XXXX-5865");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cdetails = new JLabel("*Your 16 Digit Card Number");
        cdetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cdetails.setBounds(100, 330, 300, 20);
        add(cdetails);

        JLabel pin = new JLabel("PIN: ");             //Card Number
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);
        JLabel pdetails = new JLabel("*Your 4 Digit PIN Number");      //help text
        pdetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pdetails.setBounds(100, 400, 300, 20);
        add(pdetails);

        JLabel serv = new JLabel("Services Required: ");     //services applying for
        serv.setFont(new Font("Raleway", Font.BOLD, 22));
        serv.setBounds(100, 450, 300, 20);
        add(serv);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("E-MAIL and SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE); //whole background white

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) 
        {
            String acctype = null;
            if (r1.isSelected()) {
                acctype = "Savings Account";
            } else if (r2.isSelected()) {
                acctype = "Current Account";
            } else if (r3.isSelected()) {
                acctype = "Fixed Deposit Account";
            } else if (r4.isSelected()) {
                acctype = "Reccuring  Deposit Account";
            }

            Random random = new Random();
            String cno = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pno = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card";    //multiple facility, thats why concatenating 
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";    //multiple facility, thats why concatenating 
            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";    //multiple facility, thats why concatenating 
            } else if (c4.isSelected()) {
                facility = facility + " E-MAIL and SMS Alerts";    //multiple facility, thats why concatenating 
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";    //multiple facility, thats why concatenating 
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement";    //multiple facility, thats why concatenating 
            }

            //DB part, connecting, storing and updating using MySQL Query
            try {
                if (acctype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Mandatory");
                }
                else if (!c7.isSelected()) 
                {
                    JOptionPane.showMessageDialog(null, "Kindly agree with the Terms and Conditions");
                } 
                else 
                {
                    Conn con = new Conn();
                    String q1 = "insert into signup3 values('" + formno + "','" + acctype + "','" + cno + "','" + pno + "','" + facility + "')";
                    String q2 = "insert into login values('" + formno + "','" + cno + "','" + pno + "')"; //stored credentials
                    con.s.executeUpdate(q1);
                    con.s.executeUpdate(q2);
                    
                    //this will show generated PIN and credentials
                    JOptionPane.showMessageDialog(null, ("Card Number: "+cno+"\nPIN Number: "+pno)); 
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            setVisible(false);  //sign up hote  hi u have to deposit some minimum balance, so signup3 hote hi ye display off
            new Deposit(pno).setVisible(true);   //and ye display shuru, where pin no is reference
        } 
        else if (ae.getSource() == cancel) {
            setVisible(false);       //agar cancel hua to, ye bandd
            new Login().setVisible(true);   //direct login page khulega
        }

    }

    public static void main(String arg[]) {
        new Signup3("").setVisible(true);
    }

}