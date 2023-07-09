package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Withdrawal extends JFrame implements ActionListener
{
    JTextField am;
    JButton wd,back;
    String pin;
    Withdrawal(String pin){
        
        this.pin=pin;             //pin will be used for deposit
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text=new JLabel("Enter Total amount to Withdraw: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Georgia",Font.BOLD,16));
        text.setBounds(210,300,400,20);
        image.add(text);
        
        am=new JTextField();
        am.setFont(new Font("Georgia",Font.BOLD,22));
        am.setBounds(180,350,320,25);
        image.add(am);
        
        wd=new JButton("Withdraw");
        wd.setBounds(355,485,150,30);
        wd.addActionListener(this);
        image.add(wd);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==wd)   //agar deposit pe click hua h...
        {
            String val=am.getText();
            Date date=new Date();
            if(val.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter Amount!");   //warning if user doesn't enter amount to deposit
            }
            else
            {
                try{
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pin+"','"+date+"','Withdrawl','"+val+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+val+" Withdrawled!");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);   //amount deposit hote hi transaction display khul jayega...x
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);    //back hone pe ye wala display bandd
            new Transaction(pin).setVisible(true);   //back krne ke vapas transaction display
        }
    }
    public static void main(String args[]) {
        new Withdrawal("");
    }
}
